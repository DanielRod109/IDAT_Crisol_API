package pe.crisol.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.crisol.entity.Libro2;
import pe.crisol.service.Libro2Service;

@RestController

@RequestMapping("/libro")

@CrossOrigin(origins = "http://localhost:4200")
public class Libro2Controller {

	@Autowired
	private Libro2Service service;

	public Libro2Controller() {
	}

	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {

		Collection<Libro2> collection = service.findAll();
		if (collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<>(collection, HttpStatus.OK);

	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Libro2 libro) {

		service.insert(libro);

		Map<String, String> response = new HashMap<>();

		response.put("message", "Libro registrado correctamente.");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/editar/{id_libro}")
	public ResponseEntity<?> editar_PUT(@RequestBody Libro2 nlibro, @PathVariable Integer id_libro)

	{
		Libro2 LibroDb = service.findById(id_libro);

		Map<String, String> response = new HashMap<>();

		if (LibroDb != null) {

			LibroDb.setNombre(nlibro.getNombre());

			LibroDb.setPeso(nlibro.getPeso());

			LibroDb.setEditorial(nlibro.getEditorial());

			LibroDb.setAlto(nlibro.getAlto());

			LibroDb.setAncho(nlibro.getAncho());

			LibroDb.setAedicion(nlibro.getAedicion());

			LibroDb.setNpaginas(nlibro.getNpaginas());

			LibroDb.setAutor(nlibro.getAutor());

			LibroDb.setPrecio(nlibro.getPrecio());

			LibroDb.setImg(nlibro.getImg());

			service.update(LibroDb);

			response.put("message", "Libro editado correctamente.");

			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
		response.put("message", "404 E");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@DeleteMapping("/borrar/{id_libro}")

	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_libro)

	{
		Libro2 LibroDb = service.findById(id_libro);

		if (LibroDb != null) {

			service.delete(id_libro);

			return new ResponseEntity<>("¡Libro borrado!", HttpStatus.OK);

		}

		return new ResponseEntity<>("¡Libro no existe!", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/buscar/{id_libro}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_libro) {

		Libro2 LibroDb = service.findById(id_libro);

		if (LibroDb != null) {

			return new ResponseEntity<>(LibroDb, HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Libro no existe!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/buscarNombreAutorEditorial/{nombre}")
	public ResponseEntity<?> buscarPorNombreAutorEditorial_GET(@PathVariable String nombre) {
		Collection<Libro2> librosEncontrados = service.buscarPorNombre(nombre);
		Collection<Libro2> librosporAutor = service.buscarPorAutor(nombre);
		Collection<Libro2> librosporEditorial = service.buscarPorEditorial(nombre);

		if (!librosEncontrados.isEmpty()) {
			return new ResponseEntity<>(librosEncontrados, HttpStatus.OK);
		}

		else if (!librosporAutor.isEmpty()) {
			return new ResponseEntity<>(librosporAutor, HttpStatus.OK);
		}

		else if (!librosporEditorial.isEmpty()) {
			return new ResponseEntity<>(librosporEditorial, HttpStatus.OK);
		}

		Map<String, String> response = new HashMap<>();
		response.put("message", "Lo sentimos, no pudimos encontrar tu búsqueda.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

	}

}
