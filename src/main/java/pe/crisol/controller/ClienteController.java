package pe.crisol.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.crisol.entity.Cliente;
import pe.crisol.service.ClienteService;

@CrossOrigin(origins= {"http://localhost:64299"}) //puerto de angular
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	public ClienteController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Cliente> collection = clienteService.listar();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	
	@PostMapping("/crear")
	public ResponseEntity<?> crear_POST(@RequestBody Cliente cliente) {
	    Collection<Cliente> listaClientes = clienteService.listar();
	    //String mensaje = "";
	    boolean emailEncontrado = false;
	    
	    // Validar si el email ya existe en la lista de clientes
	    for (Cliente c : listaClientes) {
	        if (c.getEmail().equalsIgnoreCase(cliente.getEmail())) {
	            emailEncontrado = true;
	            break;
	        }
	    }
	    
	    if (emailEncontrado) {
	        // El email ya existe, retornar una respuesta de error
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "El email ya está registrado, inicie sesión.");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    } else {
	        cliente.setEstado("Activo");
	        clienteService.crear(cliente);
	        
	        // Cliente creado exitosamente
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Se ha registrado correctamente.");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }
	}
	
	
	
	@PutMapping("/editar/{clienteId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Cliente cliente,
			                            @PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.buscar(clienteId);
		
		if(clienteDb!=null){
			
			cliente.setClienteId(clienteId);
			clienteService.actualizar(cliente);
			
			return new ResponseEntity<>("Datos actualizados correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontró el cliente a editar.",HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/eliminar/{clienteId}")
	public ResponseEntity<?> eliminar_DELETE( @PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.buscar(clienteId);
		
		if(clienteDb!=null){
			
			clienteService.eliminar(clienteId);
			
			return new ResponseEntity<>("Cliente eliminado correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Cliente no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{clienteId}")
	public ResponseEntity<?> buscar_GET( @PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.buscar(clienteId);
		
		if(clienteDb!=null){
			
			return new ResponseEntity<>(clienteDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Cliente no encontrado.",HttpStatus.NOT_FOUND);
	}

	
	@PostMapping("/autenticar")
	@ResponseBody
	public ResponseEntity<?> autenticar_POST(@RequestBody Cliente cliente) {
	    String email = cliente.getEmail();
	    String pass = cliente.getPassword();
	    
	    if (validarCredenciales(email, pass)=="Inicio de sesión exitoso") {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Inicio de sesión exitoso");
	        return ResponseEntity.ok().body(response);
	    } else if(email == "" || pass =="") {
	    	 Map<String, String> response = new HashMap<>();
		        response.put("message", "Complete los campos correctamente.");
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
	    else if (validarCredenciales(email, pass)=="El email ingresado no está asociado a una cuenta.") {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "El email ingresado no está asociado a una cuenta.");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	    else  {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "La contraseña ingresada es incorrecta.");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}
	
	private String validarCredenciales(String email, String pass) {
	    Collection<Cliente> listaClientes = clienteService.listar();
	    String mensaje = "";
	    boolean emailEncontrado = false;

	    for (Cliente cliente : listaClientes) {
	        if (cliente.getEmail().equals(email)) {
	            emailEncontrado = true;
	            if (verificarContraseña(pass, cliente.getPassword())) {
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
