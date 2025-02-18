package com.jtc.service;

import java.util.List;

import com.jtc.entity.Catagory;

public interface CatagoryService {
	
	public boolean saveCatagory(Catagory catagory);
	
	public List<Catagory> getAllCatagory();

}
