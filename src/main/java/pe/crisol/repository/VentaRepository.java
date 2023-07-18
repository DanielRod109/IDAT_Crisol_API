package pe.crisol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.crisol.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
	
	@Procedure(name= "obtener_ventas_cliente")
	List<Venta> obtenerVentasCliente(@Param("clienteId")int clienteId );
	

}
