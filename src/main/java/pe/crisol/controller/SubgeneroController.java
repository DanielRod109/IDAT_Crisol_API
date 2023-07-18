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

import pe.crisol.entity.Subgenero;
import pe.crisol.service.SubgeneroService;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/subgenero")
public class SubgeneroController {
	
	@Autowired
	SubgeneroService subgeneroService;
	
	public SubgeneroController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Subgenero> collection = subgeneroService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
		
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Subgenero subgenero)
	{
		subgeneroService.crear(subgenero);		
		return new ResponseEntity<>("Subgénero registrado correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{subgeneroId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Subgenero subgenero,
			                            @PathVariable Integer subgeneroId)
	{
		Subgenero subgeneroDb=subgeneroService.buscar(subgeneroId);
		
		if(subgeneroDb!=null){
			
			subgenero.setSubgeneroId(subgeneroId);
			subgeneroService.actualizar(subgenero);
			
			return new ResponseEntity<>("Subgénero actualizado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el subgénero a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{subgeneroId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer subgeneroId)
	{
		Subgenero subgeneroDb=subgeneroService.buscar(subgeneroId);
		
		if(subgeneroDb!=null){
			
			subgeneroService.eliminar(subgeneroId);
			
			return new ResponseEntity<>("Subgénero eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Subgénero no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{subgeneroId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer subgeneroId)
	{
		Subgenero subgeneroDb=subgeneroService.buscar(subgeneroId);
		
		if(subgeneroDb!=null){
			
			return new ResponseEntity<>(subgeneroDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Subgénero no encontrado.",HttpStatus.NOT_FOUND);
	}
}
