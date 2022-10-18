package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.model.Curso;
import com.ejercicio.service.CursosService;

@RestController
public class CursoController {

	@Autowired
	CursosService cursosService;
	
	@GetMapping(value="curso/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codigo") String codigo) {
		return cursosService.buscarCurso(codigo);
	}
	
	@GetMapping(value="curso/{precio1}/{precio2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursoPorPrecio(@PathVariable("precio1") float precio1, @PathVariable("precio2") float precio2) {
		return cursosService.buscarCursos(precio1, precio2);
	}
	
	@GetMapping(value="cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return cursosService.cursos();
	}
	
	@PostMapping(value="curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> guardarCurso(@RequestBody Curso curso) {
		return cursosService.guardarCurso(curso);
	}
	
	@PutMapping(value="curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modificarCurso(@RequestBody Curso curso) {
		cursosService.modificarCurso(curso);
	}
	
	@DeleteMapping(value="curso/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> borrarCurso(@PathVariable("codigo") String codigo) {
		return cursosService.borrarCurso(codigo);
	}

}
