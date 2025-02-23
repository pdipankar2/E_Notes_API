package com.jtc.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtc.dto.NotesDto;
import com.jtc.entity.Catagory;
import com.jtc.entity.FileDetails;
import com.jtc.entity.Notes;
import com.jtc.exception.ResourceNotFoundException;
import com.jtc.repo.CatagoryRepo;
import com.jtc.repo.FileRepo;
import com.jtc.repo.NotesRepo;

import jakarta.validation.constraints.NotEmpty;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NotesRepo notesRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Value("${file.upload.path}")
	private String uploadpath;

	@Autowired
	private FileRepo fileRepo;

	@Override
	public List<NotesDto> getAllNotes() {
		return notesRepo.findAll().stream().map(note -> mapper.map(note, NotesDto.class)).toList();

	}

	@Override
	public boolean saveNotes(String notes, MultipartFile file) throws Exception {

		ObjectMapper ob = new ObjectMapper();
		NotesDto notesDto = ob.readValue(notes, NotesDto.class);

	//	FileDetails fileDetails = saveFileDetails(file);
		
		
		

		// catagory validation

		checkCatagoryExist(notesDto.getCatagory());

		Notes notsMap = mapper.map(notesDto, Notes.class);
		
		FileDetails fileDetails=saveFileDetails(file);
		
		if (!ObjectUtils.isEmpty(fileDetails)) {

			notsMap.setfileDetails(fileDetails);
		}else {
			notsMap.setfileDetails(null);
		}
		

		Notes saveNotes = notesRepo.save(notsMap);

		if (ObjectUtils.isEmpty(saveNotes)) {

			return true;

		}

		return false;
	}

	// private void checkCatagoryExist(Catagory catagory) {
	// catagoryRepo.findById(catagory.getId()
	// .orElseThrow(()->new ResourceNotFoundException("Catagory id invalid"));

	// }

	private FileDetails saveFileDetails(MultipartFile file) throws IOException {

		if (!ObjectUtils.isEmpty(file) && !file.isEmpty()) {
			String originalFileName = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(originalFileName);

			List<String> extensionAllow = Arrays.asList("pdf","xlsx","png","jpg");
			if( !extensionAllow.contains(extension)) {
				throw new IllegalArgumentException("Invalid file format exception upload only pdf/xlsx/jpj/png");
			}


			

			String randomString = UUID.randomUUID().toString();

			//String extension = FilenameUtils.getExtension(originalFileName);

			String uploadedFileName = randomString + "." + extension;
			
		
			

			File saveFile = new File(uploadpath);

			if (!saveFile.exists()) {
				saveFile.mkdir();
			}
			// path:enotesService/notes/java.pdf

			String storePath = uploadpath.concat(uploadedFileName);


			// upload File

			long upload = Files.copy(file.getInputStream(), Paths.get(storePath));
			if (upload != 0) {
				FileDetails fileDetails = new FileDetails();
				fileDetails.setOriginalFileName(originalFileName);
				fileDetails.setDisplayFilename(getDisplayName(originalFileName));
				fileDetails.setUploadFileName(uploadedFileName);

				fileDetails.setFileSize(file.getSize());
				fileDetails.setPath(storePath);

				FileDetails saveFileDetails = fileRepo.save(fileDetails);
				
				

				
				return saveFileDetails;

			}
		}

		return null;
	}

	private String getDisplayName(String originalFileName) {
//java_program_tutorial.pdf
		// java_prog.pdf

		String extension = FilenameUtils.getExtension(originalFileName);

		String fileName = FilenameUtils.removeExtension(originalFileName);

		if (fileName.length() > 8) {

			fileName = fileName.substring(0, 7);
		}
		fileName = fileName + "." + extension;

		return fileName;
	}

	private void checkCatagoryExist(Catagory catagory) throws ResourceNotFoundException {

		catagoryRepo.findById(catagory.getId()).orElseThrow(() -> new ResourceNotFoundException("Catagory Id invalid"));

	}
}
