package com.jtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jtc.dto.NotesDto;
import com.jtc.service.NoteService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping("/")
	public ResponseEntity<?> saveNotes(@RequestParam String notes,@RequestParam(required = false)  MultipartFile file) throws Exception {

		boolean saveNotes = noteService.saveNotes(notes,file);

		return new ResponseEntity<>(saveNotes, HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<?> getAllNotes() {

		List<NotesDto> allNotes = noteService.getAllNotes();
		
		if(CollectionUtils.isEmpty(allNotes)){
			return  ResponseEntity.noContent().build();

		}

		return new ResponseEntity<>(allNotes, HttpStatus.OK);

	}

}
