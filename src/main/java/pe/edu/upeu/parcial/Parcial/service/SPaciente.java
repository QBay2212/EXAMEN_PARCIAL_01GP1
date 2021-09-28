package pe.edu.upeu.parcial.Parcial.service;

import java.util.List;

import pe.edu.upeu.parcial.Parcial.modelo.Paciente;

public interface SPaciente {
	Paciente create(Paciente pa);
	List<Paciente> readAll();
	Paciente read(Long id);
	void delete(Long id);
	Paciente update(Paciente pa);
	}

