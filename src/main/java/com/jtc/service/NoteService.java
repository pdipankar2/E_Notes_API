package com.jtc.service;

import java.util.List;

import com.jtc.dto.NotesDto;
import com.jtc.exception.ResourceNotFoundException;

public interface NoteService {

	public boolean saveNotes(NotesDto notesDto) throws ResourceNotFoundException;
	
	public List<NotesDto> getAllNotes();
}
