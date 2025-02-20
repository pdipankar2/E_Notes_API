package com.jtc.validaton;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.jtc.dto.CatagoryDTO;

@Component
public class Validaton {

	
	public void CatagoryValidation(CatagoryDTO catagoryDTO) throws IllegalAccessException {
	
		Map<String, Object> error=new LinkedHashMap<>();
		//validation name field
		if(ObjectUtils.isEmpty(catagoryDTO.getName())) {
			error.put("name", "name field is empty or null");
		}else {
			if(catagoryDTO.getName().length()<5) {
				error.put("name", "name length grater then 5 character");

			}
			if(catagoryDTO.getName().length()>100) {
				error.put("name", "name length less  then 100 character");

			}
			}
		//validation name field
		
		if(ObjectUtils.isEmpty(catagoryDTO.getDescription())) {
			error.put("Description", "Descripton field is empty or null");
		}
		
		/*
		 * //validation isActive field
		 * 
		 * if(ObjectUtils.isEmpty(catagoryDTO.getIsActive())) {
		 * 
		 * error.put("isActive", "isActive field is empty or null");
		 * 
		 * }else { if(!catagoryDTO.getIsActive()==Boolean.TRUE ||
		 * !catagoryDTO.getIsActive()==Boolean.FALSE); error.put("isActive",
		 * " Invalid value isActive field ");
		 * 
		 * }
		 */
}
}

