package com.ejercicio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ejercicio.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {
	
	@Query("Select c from Curso c where c.precio >= ?1 and c.precio <= ?2")
	List<Curso> findByPrecios(float precio1, float precio2);

}
