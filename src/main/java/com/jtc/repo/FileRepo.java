package com.jtc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jtc.entity.FileDetails;

@Repository
public interface FileRepo extends JpaRepository<FileDetails, Integer> {

}
