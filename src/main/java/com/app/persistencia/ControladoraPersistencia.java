package com.app.persistencia;

import com.app.logica.Gato;
import com.app.logica.Adoptante;
import java.util.List;

public class ControladoraPersistencia {

	// Creamos los controladores para hablar con la base de datos.
	GatoJpaController gatoJpa = new GatoJpaController();

	AdoptanteJpaController adoptanteJpa = new AdoptanteJpaController();

	// Método para crear un Gato.
	public void crearGato(Gato gato) {

		gatoJpa.crear(gato);

	}

	// Método para crear un Adoptante.
	public void crearAdoptante(Adoptante adoptante) {

		adoptanteJpa.crear(adoptante);

	}

	// BUSCAR UN GATO
	public Gato buscarGato(int id) {
		return gatoJpa.buscarUno(id);
	}

	// BUSCAR TODOS LOS GATOS
	public List<Gato> buscarTodosLosGatos() {
		return gatoJpa.buscarTodos();
	}

	// BUSCAR UN ADOPTANTE
	public Adoptante buscarAdoptante(int id) {
		return adoptanteJpa.buscarUno(id);
	}

	// BUSCAR TODOS LOS ADOPTANTES
	public List<Adoptante> buscarTodosLosAdoptantes() {
		return adoptanteJpa.buscarTodos();
	}

	// EDITAR UN GATO
	public void editarGato(Gato gato) {
		gatoJpa.editar(gato);
	}

	// ELIMINAR UN GATO
	public void eliminarGato(int id) {
		gatoJpa.eliminar(id);
	}

	// EDITAR UN ADOPTANTE
	public void editarAdoptante(Adoptante adoptante) {
		adoptanteJpa.editar(adoptante);
	}

	// ELIMINAR UN ADOPTANTE
	public void eliminarAdoptante(int id) {
		adoptanteJpa.eliminar(id);
	}
	// BUSCAR GATOS POR NOMBRE

	public List<Gato> buscarGatosPorNombre(String nombre) {
		return gatoJpa.buscarPorNombre(nombre);
	}

}