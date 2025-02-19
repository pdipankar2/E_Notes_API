package com.jtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtc.dto.CatagoryDTO;
import com.jtc.dto.CatagoryResponse;
import com.jtc.entity.Catagory;
import com.jtc.repo.CatagoryRepo;
import com.jtc.service.CatagoryService;

@RestController
@RequestMapping("/api/v1/catagory")
public class CatagoryController {

	@Autowired
	private CatagoryService catagoryService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCatagory(@RequestBody CatagoryDTO catagory) {

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

	@GetMapping("/active-catagory")
	public ResponseEntity<?> getActiveCatagory() {

		// List<CatagoryResponse> allCatagory = (List<CatagoryResponse>)
		// catagoryService.getActiveCatagory();

		List<CatagoryResponse> activeCatagory = catagoryService.getActiveCatagory();

		if (ObjectUtils.isEmpty(activeCatagory)) {

			return ResponseEntity.noContent().build();

		} else {
			return new ResponseEntity<>(activeCatagory, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCreateCatagoryById(@PathVariable Integer id) {

		CatagoryDTO catagoryDTO = catagoryService.getCatagoryById(id);

		if (ObjectUtils.isEmpty(catagoryDTO)) {
			return new ResponseEntity<>("Catagory not found By Id-"+id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(catagoryDTO, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> getCatagoryDeleteById(@PathVariable Integer id) {

		Boolean delete = catagoryService.deletedcatagoryById(id);

		if (delete) {
			return new ResponseEntity<>("Catagory Deleted Successfully", HttpStatus.OK);
		}

		return new ResponseEntity<>("Catagory Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
