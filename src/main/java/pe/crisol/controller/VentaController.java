package pe.crisol.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.crisol.dto.VentaDetalleDTO;
import pe.crisol.entity.DetalleVenta;
import pe.crisol.entity.Venta;
import pe.crisol.service.DetalleVentaService;
import pe.crisol.service.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	VentaService ventaservice;
	
	@Autowired
	DetalleVentaService dventaservice;
	
	public VentaController() {
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_Ventas(){
		
		Collection<Venta> collection = ventaservice.listartotal();
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}
	
	@GetMapping("/clientes/{clienteId}")
	public ResponseEntity<?> listar_VentasClientes(@PathVariable Integer clienteId){
		
		Collection<Venta> collection = ventaservice.listarcliente(clienteId);
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}
	
    @GetMapping("/buscar/{ventaId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer ventaId){

        Venta VentaDb = ventaservice.buscar(ventaId);

        if(VentaDb!=null) {

            return new ResponseEntity<>(VentaDb,HttpStatus.OK);
        }
        return new ResponseEntity<>("Venta no existe!",HttpStatus.NOT_FOUND);
    }
    
    
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVenta(@RequestBody VentaDetalleDTO dto){
    	
    	Map<String, String> response = new HashMap<>();
    	
    	Venta nuevaVenta = ventaservice.crear(dto.getVenta());
    	
    	for(DetalleVenta dventa: dto.getDetalles() ) {
    		dventa.setVenta(nuevaVenta);
    		dventaservice.crear(dventa);
    	}
    	
    	response.put("message", "Venta registrada con éxito!");
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    	
    }
    
    
    

}
