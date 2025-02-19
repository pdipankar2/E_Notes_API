package com.jtc.service;

import java.util.List;

import com.jtc.dto.CatagoryDTO;
import com.jtc.dto.CatagoryResponse;
import com.jtc.entity.Catagory;
import com.jtc.repo.CatagoryRepo;

public interface CatagoryService {
	
	public boolean saveCatagory(CatagoryDTO catagory);
	
	public List<Catagory> getAllCatagory();

	public List<CatagoryResponse> getActiveCatagory();

}
