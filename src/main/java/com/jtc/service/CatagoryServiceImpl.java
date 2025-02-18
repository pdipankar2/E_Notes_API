package com.jtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jtc.entity.Catagory;
import com.jtc.repo.CatagoryRepo;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Override
	public boolean saveCatagory(Catagory catagory) {

		catagory.setIsDelete(false);
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

}
