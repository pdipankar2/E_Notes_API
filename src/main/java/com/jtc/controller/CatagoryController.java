package com.jtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtc.entity.Catagory;
import com.jtc.service.CatagoryService;

@RestController
@RequestMapping("/api/v1/catagory")
public class CatagoryController {

	@Autowired
	private CatagoryService catagoryService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCatagory(@RequestBody Catagory catagory) {

		boolean saveCatagory = catagoryService.saveCatagory(catagory);
		if (saveCatagory) {
			return new ResponseEntity<>("Save Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Not Save", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllCatagory() {

		List<Catagory> allCatagory = catagoryService.getAllCatagory();
		if (ObjectUtils.isEmpty(allCatagory)) {

			return ResponseEntity.noContent().build();
			
		} else {
			return new ResponseEntity<>(allCatagory, HttpStatus.OK);
		}

	}

}
