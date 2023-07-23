package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Venta;

public interface VentaService {
	public abstract Venta crear(Venta venta);
	//public abstract void actualizar(Usuario usuario);
	//public abstract void eliminar(Integer usuarioId);
	
	
	
	
	public abstract Venta buscar(Integer ventaId);
	
	public abstract Collection<Venta> listartotal();
	
	public abstract Collection<Venta> listarcliente(Integer clienteId);
	

}
