package pe.crisol.controller;

//import java.util.Collection;

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

import pe.crisol.entity.Libro;
import pe.crisol.service.LibroService;
import pe.crisol.util.MapperCrisol;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/libro1")
public class LibroController {

	@Autowired
	LibroService libroService;
	
	public LibroController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		/*Collection<Libro> collection = libroService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);*/
		return new ResponseEntity<>(MapperCrisol.toLibros(libroService.listar()) ,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Libro libro)
	{
		libroService.crear(libro);		
		return new ResponseEntity<>("Libro registrado correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{libroId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Libro libro,
			                            @PathVariable Integer libroId)
	{
		Libro libroDb=libroService.buscar(libroId);
		
		if(libroDb!=null){
			
			libro.setLibroId(libroId);
			libroService.actualizar(libro);
			
			return new ResponseEntity<>("Libro actualizado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el Libro a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{libroId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer libroId)
	{
		Libro libroDb=libroService.buscar(libroId);
		
		if(libroDb!=null){
			
			libroService.eliminar(libroId);
			
			return new ResponseEntity<>("Libro eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Libro no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{libroId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer libroId)
	{
		Libro libroDb=libroService.buscar(libroId);
		
		if(libroDb!=null){
			
			return new ResponseEntity<>(libroDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Libro no encontrado.",HttpStatus.NOT_FOUND);
	}
	
}
