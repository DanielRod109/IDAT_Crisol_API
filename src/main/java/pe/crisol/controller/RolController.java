package pe.crisol.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.crisol.entity.Rol;
import pe.crisol.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	RolService rolService;
	
	public RolController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Rol> collection = rolService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Rol rol)
	{
		rolService.crear(rol);		
		return new ResponseEntity<>("Rol registrado correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{rolId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Rol rol,
			                            @PathVariable Integer rolId)
	{
		Rol rolDb=rolService.buscar(rolId);
		
		if(rolDb!=null){
			
			rol.setRolId(rolId);
			rolService.actualizar(rol);
			
			return new ResponseEntity<>("Rol actualizado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el rol a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{rolId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer rolId)
	{
		Rol rolDb=rolService.buscar(rolId);
		
		if(rolDb!=null){
			
			rolService.eliminar(rolId);
			
			return new ResponseEntity<>("Rol eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Rol no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{rolId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer rolId)
	{
		Rol rolDb=rolService.buscar(rolId);
		
		if(rolDb!=null){
			
			return new ResponseEntity<>(rolDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Rol no encontrado.",HttpStatus.NOT_FOUND);
	}
}
