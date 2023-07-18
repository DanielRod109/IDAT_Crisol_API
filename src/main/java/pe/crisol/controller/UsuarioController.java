package pe.crisol.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.crisol.entity.Usuario;
import pe.crisol.service.UsuarioService;
import pe.crisol.util.MapperCrisol;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	public UsuarioController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		/*Collection<Usuario> collection = usuarioService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);*/
		return new ResponseEntity<>(MapperCrisol.toUsuarios(usuarioService.listar()) ,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Usuario usuario)
	{
		usuario.setEstado("Activo");
		usuarioService.crear(usuario);		
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado correctamente.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	
	@PutMapping("/editar/{usuarioId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Usuario usuario,
			                            @PathVariable Integer usuarioId)
	{
		Map<String, String> response = new HashMap<>();
		Usuario usuarioDb=usuarioService.buscar(usuarioId);
		
		if(usuarioDb!=null){
			
			usuario.setUsuarioId(usuarioId);
			usuarioService.actualizar(usuario);
			
			 response.put("message", "Se ha registrado correctamente.");
		        return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		response.put("message", "No se encontró al usuario a editar.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	
	
	@DeleteMapping("/eliminar/{usuarioId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer usuarioId)
	{
		Usuario usuarioDb=usuarioService.buscar(usuarioId);
		
		if(usuarioDb!=null){
			
			usuarioService.eliminar(usuarioId);
			
			return new ResponseEntity<>("Usuario eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Usuario no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{usuarioId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer usuarioId)
	{
		Usuario usuarioDb=usuarioService.buscar(usuarioId);
		
		if(usuarioDb!=null){
			
			return new ResponseEntity<>(usuarioDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Usuario no encontrado.",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/autenticar")
	@ResponseBody
	public ResponseEntity<?> autenticar_POST(@RequestBody Usuario usuario) {
	    String email = usuario.getEmail();
	    String pass = usuario.getPassword();
	    
	    String rol = "No se encontró"; 
	    String nombre="Nombres y Apellidos";
	    
	    Collection<Usuario> listarUsuarios = usuarioService.listar();
	    for (Usuario usuariobd : listarUsuarios) {
	        if (usuariobd.getEmail().equals(email)) {
	        	rol = usuariobd.getRol().getNombre_rol();
	        	nombre = usuariobd.getNombre_trabajador();
	            break;
	        }
	    }
	    
	    
	    
	    Map<String, String> response = new HashMap<>();
	    
	    if (validarCredenciales(email, pass)=="Inicio de sesión exitoso") {
	        response.put("message", "Inicio de sesión exitoso");
	        response.put("rolUsuario", rol);
	        response.put("nombres", nombre);
	        return ResponseEntity.ok().body(response);
	    } else if(email == "" || pass =="") {
		        response.put("message", "Complete los campos correctamente.");
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
	    else if (validarCredenciales(email, pass)=="El email ingresado no está asociado a una cuenta.") {
	      
	        response.put("message", "El email ingresado no está asociado a una cuenta.");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	    else if (validarCredenciales(email, pass)=="La contraseña ingresada es incorrecta.") {
	        response.put("message", "La contraseña ingresada es incorrecta.");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	    
	    response.put("message", "Error al ingresar");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	private String validarCredenciales(String email, String pass) {
	    Collection<Usuario> listaUsuario = usuarioService.listar();
	    String mensaje = "";
	    boolean emailEncontrado = false;

	    for (Usuario usuario : listaUsuario) {
	        if (usuario.getEmail().equals(email)) {
	            emailEncontrado = true;
	            if (verificarContraseña(pass, usuario.getPassword())) {
	                mensaje = "Inicio de sesión exitoso";
	            } else {
	                mensaje = "La contraseña ingresada es incorrecta.";
	            }
	            break; // No es necesario seguir iterando una vez que se encuentra el email
	        }
	    }

	    if (!emailEncontrado) {
	        mensaje = "El email ingresado no está asociado a una cuenta.";
	    }

	    return mensaje;
	}

	
	public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(password.getBytes());
            String encryptedPassword = Base64.getEncoder().encodeToString(hash);
            return encryptedPassword;
        } catch (NoSuchAlgorithmException e) {
        	return null;
        }
       
    }
	
	public boolean verificarContraseña(String contraseñaIngresada, String contraseñaEncriptada) {
	    String contraseñaEncriptadaIngresada = encryptPassword(contraseñaIngresada);
	    return contraseñaEncriptadaIngresada.equals(contraseñaEncriptada);
	}
}