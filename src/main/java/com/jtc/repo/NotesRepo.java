package com.jtc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jtc.entity.Notes;

public interface NotesRepo  extends JpaRepository<Notes,Integer>{

}
