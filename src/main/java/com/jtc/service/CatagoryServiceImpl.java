package com.jtc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jtc.dto.CatagoryDTO;
import com.jtc.dto.CatagoryResponse;
import com.jtc.entity.Catagory;
import com.jtc.repo.CatagoryRepo;
import com.jtc.validaton.Validaton;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validaton validaton;
	
	@Override
	public boolean saveCatagory(CatagoryDTO catagoryDTO) throws Exception {

		validaton.CatagoryValidation(catagoryDTO);
		
		//Catagory catagory = new Catagory();
		//catagory.setName(catagoryDTO.getName());
		//catagory.setDescription(catagoryDTO.getDescription());
		//catagory.setIsActive(catagoryDTO.getIsActive());
		//validation check
		
		
		
		Catagory catagory = mapper.map(catagoryDTO, Catagory.class);

		if (ObjectUtils.isEmpty(catagory.getId())) {

			catagory.setIsDelete(false);
			catagory.setCreatedBy(1);
			catagory.setCreatedOn(new Date());
		} else {
			updateCatagory(catagory);
		}

		Catagory save = catagoryRepo.save(catagory);

		if (ObjectUtils.isEmpty(save)) {
			return false;
		}
		return true;
	}

	private void updateCatagory(Catagory catagory) {

		Optional<Catagory> findById = catagoryRepo.findById(catagory.getId());
		if (findById.isPresent()) {
			Catagory existCatagory = findById.get();
			catagory.setCreatedBy(existCatagory.getCreatedBy());
			catagory.setCreatedOn(existCatagory.getCreatedOn());
			catagory.setIsDelete(existCatagory.getIsDelete());
			catagory.setUpadtedBy(1);
			catagory.setUpdateOn(new Date());
		}

	}

	@Override
	public List<Catagory> getAllCatagory() {

		// List<Catagory> all = catagoryRepo.findAll();
		List<Catagory> all = catagoryRepo.findByIsDeleteFalse();

		return all;
	}

	@Override
	public List<CatagoryResponse> getActiveCatagory() {
		List<Catagory> catagorys = catagoryRepo.findByIsActiveTrueAndIsDeleteFalse();

		List<CatagoryResponse> catagorylist = catagorys.stream().map(cat -> mapper.map(cat, CatagoryResponse.class))
				.toList();
		return catagorylist;
	}

	@Override
	public CatagoryDTO getCatagoryById(Integer id) {

		Optional<Catagory> findByCatagory = catagoryRepo.findByIdAndIsDeleteFalse(id);

		if (findByCatagory.isPresent()) {

			Catagory catagory = findByCatagory.get();
			return mapper.map(catagory, CatagoryDTO.class);

		}

		return null;
	}

	@Override
	public Boolean deletedcatagoryById(Integer id) {

		Optional<Catagory> FindByCatagory = catagoryRepo.findById(id);

		if (FindByCatagory.isPresent()) {
			Catagory catagory = FindByCatagory.get();
			catagory.setIsDelete(true);
			catagoryRepo.save(catagory);
			return true;
		}

		return false;
	}

}
