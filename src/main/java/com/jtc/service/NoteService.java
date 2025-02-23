package com.jtc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jtc.dto.NotesDto;
import com.jtc.exception.ResourceNotFoundException;

public interface NoteService {

	public boolean saveNotes(String notes,MultipartFile file ) throws ResourceNotFoundException, Exception;
	
	public List<NotesDto> getAllNotes();
}
