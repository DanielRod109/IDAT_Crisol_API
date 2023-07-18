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

import pe.crisol.entity.Permiso;
import pe.crisol.service.PermisoService;

@RestController
@RequestMapping("/permiso")
public class PermisoController {
	
	@Autowired
	PermisoService permisoService;
	
	public PermisoController() {
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Permiso> collection = permisoService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Permiso permiso)
	{
		permisoService.crear(permiso);		
		return new ResponseEntity<>("Permiso registrado correctamente.",HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/editar/{permisoId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Permiso permiso,
			                            @PathVariable Integer permisoId)
	{
		Permiso permisoDb=permisoService.buscar(permisoId);
		
		if(permisoDb!=null){
			
			permiso.setPermisoId(permisoId);
			permisoService.actualizar(permiso);
			
			return new ResponseEntity<>("Permiso actualizado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el permiso a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{permisoId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer permisoId)
	{
		Permiso permisoDb=permisoService.buscar(permisoId);
		
		if(permisoDb!=null){
			
			permisoService.eliminar(permisoId);
			
			return new ResponseEntity<>("Permiso eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Permiso no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{permisoId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer permisoId)
	{
		Permiso permisoDb=permisoService.buscar(permisoId);
		
		if(permisoDb!=null){
			
			
			return new ResponseEntity<>(permisoDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Permiso no encontrado.",HttpStatus.NOT_FOUND);
	}
	
	
}
