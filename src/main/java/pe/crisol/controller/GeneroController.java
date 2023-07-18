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

import pe.crisol.entity.Genero;
import pe.crisol.service.GeneroService;
import pe.crisol.util.MapperCrisol;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/genero")
public class GeneroController {
	
	@Autowired
	GeneroService generoService;
	
	public GeneroController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		/*Collection<Genero> collection = generoService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);*/
		return new ResponseEntity<>(MapperCrisol.toGeneros(generoService.listar()) ,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Genero genero)
	{
		generoService.crear(genero);		
		return new ResponseEntity<>("Género registrado correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{generoId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Genero genero,
			                            @PathVariable Integer generoId)
	{
		Genero generoDb=generoService.buscar(generoId);
		
		if(generoDb!=null){
			
			genero.setGeneroId(generoId);
			generoService.actualizar(genero);
			
			return new ResponseEntity<>("Género actualizado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el género a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{generoId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer generoId)
	{
		Genero generoDb=generoService.buscar(generoId);
		
		if(generoDb!=null){
			
			generoService.eliminar(generoId);
			
			return new ResponseEntity<>("Género eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Género no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{generoId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer generoId)
	{
		Genero generoDb=generoService.buscar(generoId);
				
				if(generoDb!=null){
			
			
			return new ResponseEntity<>(generoDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Género no encontrado.",HttpStatus.NOT_FOUND);
	}
}
