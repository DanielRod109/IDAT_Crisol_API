package pe.crisol.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.crisol.entity.Venta;
import pe.crisol.service.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	VentaService service;
	
	public VentaController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_Ventas(){
		
		Collection<Venta> collection = service.listartotal();
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}
	
	@GetMapping("/clientes/{clienteId}")
	public ResponseEntity<?> listar_VentasClientes(@PathVariable Integer clienteId){
		
		Collection<Venta> collection = service.listarcliente(clienteId);
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}
	
    @GetMapping("/buscar/{ventaId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer ventaId){

        Venta VentaDb = service.buscar(ventaId);

        if(VentaDb!=null) {

            return new ResponseEntity<>(VentaDb,HttpStatus.OK);
        }
        return new ResponseEntity<>("Venta no existe!",HttpStatus.NOT_FOUND);
    }

}
