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

import pe.crisol.entity.Categoria;
import pe.crisol.service.CategoriaService;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	public CategoriaController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Categoria> collection = categoriaService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Categoria categoria)
	{
		categoriaService.crear(categoria);		
		return new ResponseEntity<>("Categoría registrada correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{categoriaId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Categoria categoria,
			                            @PathVariable Integer categoriaId)
	{
		Categoria categoriaDb=categoriaService.buscar(categoriaId);
		
		if(categoriaDb!=null){
			
			categoria.setCategoriaId(categoriaId);
			categoriaService.actualizar(categoria);
			
			return new ResponseEntity<>("Categoría actualizada correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró la categoría a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{categoriaId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer categoriaId)
	{
		Categoria categoriaDb=categoriaService.buscar(categoriaId);
		
		if(categoriaDb!=null){
			
			categoriaService.eliminar(categoriaId);
			
			return new ResponseEntity<>("Categoría eliminada correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Categoría no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{categoriaId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer categoriaId)
	{
		Categoria categoriaDb=categoriaService.buscar(categoriaId);
		
		if(categoriaDb!=null){
			
			return new ResponseEntity<>(categoriaDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Categoría no encontrada.",HttpStatus.NOT_FOUND);
	}
}
