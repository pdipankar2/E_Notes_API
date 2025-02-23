package com.jtc.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jtc.dto.NotesDto;
import com.jtc.entity.Catagory;
import com.jtc.entity.Notes;
import com.jtc.exception.ResourceNotFoundException;
import com.jtc.repo.CatagoryRepo;
import com.jtc.repo.NotesRepo;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NotesRepo notesRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Override
	public List<NotesDto> getAllNotes() {
		return notesRepo.findAll().stream().map(note -> mapper.map(note, NotesDto.class)).toList();

	}

	@Override
	public boolean saveNotes(NotesDto notesDto) throws ResourceNotFoundException {

		// catagory validation

		checkCatagoryExist(notesDto.getCatagory());

		Notes nots = mapper.map(notesDto, Notes.class);

		Notes saveNotes = notesRepo.save(nots);

		if (ObjectUtils.isEmpty(saveNotes)) {

			return true;

		}

		return false;
	}

	// private void checkCatagoryExist(Catagory catagory) {
	// catagoryRepo.findById(catagory.getId()
	// .orElseThrow(()->new ResourceNotFoundException("Catagory id invalid"));

	// }

	private void checkCatagoryExist(Catagory catagory) throws ResourceNotFoundException {

		catagoryRepo.findById(catagory.getId())
		.orElseThrow(() -> new ResourceNotFoundException("Catagory Id invalid"));

	}
}
