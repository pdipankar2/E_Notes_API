package com.jtc.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;

import com.jtc.config.ProjectConfig;
import com.jtc.dto.CatagoryDTO;
import com.jtc.dto.CatagoryResponse;
import com.jtc.entity.Catagory;
import com.jtc.repo.CatagoryRepo;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean saveCatagory(CatagoryDTO catagoryDTO) {

		Catagory catagory = new Catagory();
		catagory.setName(catagoryDTO.getName());
		catagory.setDescription(catagoryDTO.getDescription());
		catagory.setIsActive(catagoryDTO.getIsActive());

		
		catagory.setIsDelete(false);
		catagory.setCreatedBy(1);
		catagory.setCreatedOn(new Date());
		Catagory save = catagoryRepo.save(catagory);
		if (ObjectUtils.isEmpty(save)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Catagory> getAllCatagory() {

		List<Catagory> all = catagoryRepo.findAll();

		return all;
	}

	@Override
	public List<CatagoryResponse> getActiveCatagory() {
		List<Catagory> catagorys = catagoryRepo.findByIsActiveTrue();

		List<CatagoryResponse> catagorylist = catagorys.stream().map(cat -> mapper.map(cat, CatagoryResponse.class))
				.toList();
		return catagorylist;
	}

}
