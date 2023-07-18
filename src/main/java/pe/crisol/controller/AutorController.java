package pe.crisol.controller;

import java.util.Collection;

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

import pe.crisol.entity.Autor;
import pe.crisol.service.AutorService;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/autor")
public class AutorController {
	@Autowired
	AutorService autorService;
	
	public AutorController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Autor> collection = autorService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Autor autor)
	{
		autorService.crear(autor);		
		return new ResponseEntity<>("Autor registrado correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{autorId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Autor autor,
			                            @PathVariable Integer autorId)
	{
		Autor autorDb=autorService.buscar(autorId);
		
		if(autorDb!=null){
			
			autor.setAutorId(autorId);
			autorService.actualizar(autor);
			
			return new ResponseEntity<>("Autor actualizado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el autor a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{autorId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer autorId)
	{
		Autor autorDb=autorService.buscar(autorId);
		
		if(autorDb!=null){
			
			autorService.eliminar(autorId);
			
			return new ResponseEntity<>("Autor eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Autor no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{autorId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer autorId)
	{
		Autor autorDb=autorService.buscar(autorId);
		
		if(autorDb!=null){
			
			return new ResponseEntity<>(autorDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Autor no encontrada.",HttpStatus.NOT_FOUND);
	}
}
