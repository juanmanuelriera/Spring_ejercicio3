package com.ejercicio.service;

import java.util.List;

import com.ejercicio.model.Curso;

public interface CursosService {
	
	Curso buscarCurso(String codigo);
	List<Curso> cursos();
	List<Curso> guardarCurso(Curso curso);
	void modificarCurso(Curso curso);
	List<Curso> borrarCurso(String codigo);
	List<Curso> buscarCursos(float precio1, float precio2);
}
