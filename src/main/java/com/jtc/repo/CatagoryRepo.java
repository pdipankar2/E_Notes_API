package com.jtc.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jtc.entity.Catagory;

@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, Integer>  {


	List<Catagory> findByIsActiveTrueAndIsDeleteFalse();

	Optional<Catagory> findByIdAndIsDeleteFalse(Integer id);

	

	List<Catagory> findByIsDeleteFalse();

	Boolean existsByName(String trim);



}
