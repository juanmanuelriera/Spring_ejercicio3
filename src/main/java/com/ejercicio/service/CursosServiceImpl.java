package com.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.CursosDao;
import com.ejercicio.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosDao cursosDao;
	
	@Override
	public Curso buscarCurso(String codigo) {
		return cursosDao.findById(codigo).orElse(null);
	}
	
	@Override
	public List<Curso> buscarCursos(float precio1, float precio2) {
		return cursosDao.findByPrecios(precio1, precio2);
	}

	@Override
	public List<Curso> cursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Curso> guardarCurso(Curso curso) {
		cursosDao.save(curso);
		return cursosDao.findAll();
	}

	@Override
	public void modificarCurso(Curso curso) {
		cursosDao.save(curso);
	}

	@Override
	public List<Curso> borrarCurso(String codigo) {
		cursosDao.deleteById(codigo);
		return cursosDao.findAll();
	}

}
