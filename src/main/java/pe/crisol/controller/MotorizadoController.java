package pe.crisol.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

import pe.crisol.entity.Motorizado;
import pe.crisol.service.MotorizadoService;

@RestController
@RequestMapping("/motorizado")
@CrossOrigin(origins = "http://localhost:4200")
public class MotorizadoController {

	@Autowired
	private MotorizadoService service;

	public MotorizadoController() {
	}

	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Motorizado> collection = service.listar();
		if (collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Motorizado motorizado) {

		service.crear(motorizado);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Motorizado registrado correctamente.");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/editar/{motorizadoId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Motorizado nmotorizado, @PathVariable Integer motorizadoId)

	{
		Motorizado MotorizadoDb = service.buscar(motorizadoId);
		Map<String, String> response = new HashMap<>();

		if (MotorizadoDb != null) {

			MotorizadoDb.setNombres(nmotorizado.getNombres());

			MotorizadoDb.setApellidos(nmotorizado.getApellidos());

			MotorizadoDb.setDni(nmotorizado.getDni());

			MotorizadoDb.setPlaca(nmotorizado.getPlaca());

			service.actualizar(MotorizadoDb);

			response.put("message", "Motorizado editado correctamente.");

			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
		response.put("message", "404 E");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@DeleteMapping("/borrar/{motorizadoId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer motorizadoId) {
		Motorizado MotorizadoDb = service.buscar(motorizadoId);

		if (MotorizadoDb != null) {
			service.eliminar(motorizadoId);

			return new ResponseEntity<>("Motorizado borrado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡Motorizado no existe!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/buscar/{motorizadoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer motorizadoId) {

		Motorizado MotorizadoDb = service.buscar(motorizadoId);

		if (MotorizadoDb != null) {

			return new ResponseEntity<>(MotorizadoDb, HttpStatus.OK);

		}

		return new ResponseEntity<>("¡Motorizado no existe!", HttpStatus.NOT_FOUND);

	}

}
