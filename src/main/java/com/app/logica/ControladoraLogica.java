package com.app.logica;

import com.app.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

	// La controladora de persistencia se encarga de hablar con la BD.
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	// ----- GATO -----

	public void crearGato(Gato gato) throws Exception {

		// Validación: el gato debe tener un nombre.
		if (gato.getNombre() == null || gato.getNombre().isEmpty()) {
			throw new Exception("El gato debe tener un nombre.");
		}

		// Validación: la edad no puede ser negativa.
		if (gato.getEdad() < 0) {
			throw new Exception("La edad del gato no puede ser negativa.");
		}

		// Validación: debe tener una raza.
		if (gato.getRaza() == null || gato.getRaza().isEmpty()) {
			throw new Exception("El gato debe tener una raza.");
		}

		// Validación: el peso debe ser mayor a cero.
		if (gato.getPeso() <= 0) {
			throw new Exception("El peso del gato debe ser mayor a 0.");
		}

		// Si pasa las validaciones, se guarda.
		controlPersis.crearGato(gato);
	}

	// ----- ADOPTANTE -----

	public void crearAdoptante(Adoptante adop) throws Exception {

		// Validación: debe tener un nombre.
		if (adop.getNombre() == null || adop.getNombre().isEmpty()) {
			throw new Exception("El adoptante debe tener un nombre.");
		}

		// Validación: debe tener un apellido.
		if (adop.getApellido() == null || adop.getApellido().isEmpty()) {
			throw new Exception("El adoptante debe tener un apellido.");
		}

		// Validación: debe tener un teléfono.
		if (adop.getTelefono() == null || adop.getTelefono().isEmpty()) {
			throw new Exception("El adoptante debe tener un teléfono.");
		}

		// Validación: debe tener un correo.
		if (adop.getCorreo() == null || adop.getCorreo().isEmpty()) {
			throw new Exception("El adoptante debe tener un correo.");
		}

		// Si pasa las validaciones, se guarda.
		controlPersis.crearAdoptante(adop);
	}

	// BUSCAR UN GATO por su id
	public Gato buscarUnGato(int id) {
		return controlPersis.buscarGato(id);
	}

	// LISTAR TODOS LOS GATOS
	public List<Gato> listarGatos() {
		return controlPersis.buscarTodosLosGatos();
	}

	// BUSCAR UN ADOPTANTE por su id
	public Adoptante buscarUnAdoptante(int id) {
		return controlPersis.buscarAdoptante(id);
	}

	// LISTAR TODOS LOS ADOPTANTES
	public List<Adoptante> listarAdoptantes() {
		return controlPersis.buscarTodosLosAdoptantes();
	}

	// ----- EDITAR GATO -----
	public void editarGato(Gato gato) throws Exception {

		Gato existente = controlPersis.buscarGato(gato.getId());

		if (existente == null) {
			throw new Exception("No existe un gato con ese ID.");
		}

		if (gato.getNombre() == null || gato.getNombre().isEmpty()) {
			throw new Exception("El gato debe tener un nombre.");
		}

		if (gato.getEdad() < 0) {
			throw new Exception("La edad del gato no puede ser negativa.");
		}

		if (gato.getRaza() == null || gato.getRaza().isEmpty()) {
			throw new Exception("El gato debe tener una raza.");
		}

		if (gato.getPeso() <= 0) {
			throw new Exception("El peso del gato debe ser mayor a 0.");
		}

		controlPersis.editarGato(gato);
	}

	// ----- ELIMINAR GATO -----
	public void eliminarGato(int id) throws Exception {

		Gato gato = controlPersis.buscarGato(id);

		if (gato == null) {
			throw new Exception("No existe un gato con ese ID.");
		}

		controlPersis.eliminarGato(id);
	}

	// ----- EDITAR ADOPTANTE -----
	public void editarAdoptante(Adoptante adop) throws Exception {

		Adoptante existente = controlPersis.buscarAdoptante(adop.getId());

		if (existente == null) {
			throw new Exception("No existe un adoptante con ese ID.");
		}

		if (adop.getNombre() == null || adop.getNombre().isEmpty()) {
			throw new Exception("El adoptante debe tener un nombre.");
		}

		if (adop.getApellido() == null || adop.getApellido().isEmpty()) {
			throw new Exception("El adoptante debe tener un apellido.");
		}

		if (adop.getTelefono() == null || adop.getTelefono().isEmpty()) {
			throw new Exception("El adoptante debe tener un teléfono.");
		}

		if (adop.getCorreo() == null || adop.getCorreo().isEmpty()) {
			throw new Exception("El adoptante debe tener un correo.");
		}

		controlPersis.editarAdoptante(adop);
	}

	// ----- ELIMINAR ADOPTANTE -----
	public void eliminarAdoptante(int id) throws Exception {

		Adoptante adop = controlPersis.buscarAdoptante(id);

		if (adop == null) {
			throw new Exception("No existe un adoptante con ese ID.");
		}

		controlPersis.eliminarAdoptante(id);
	}

	// BUSCAR GATOS POR NOMBRE
	public List<Gato> buscarGatosPorNombre(String nombre) throws Exception {

		if (nombre == null || nombre.trim().isEmpty()) {
			throw new Exception("Ingresá el nombre del gato que querés buscar.");
		}

		return controlPersis.buscarGatosPorNombre(nombre.trim());
	}

}