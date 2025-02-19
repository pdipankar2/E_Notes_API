package com.jtc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jtc.entity.Catagory;

@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, Integer>  {

}
