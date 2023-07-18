package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Motorizado;

public interface MotorizadoService {
	
	public abstract void crear(Motorizado motorizado);
	public abstract void actualizar(Motorizado motorizado);
	public abstract void eliminar(Integer motorizadoId);
	public abstract Motorizado buscar(Integer motorizadoId);
	public abstract Collection<Motorizado> listar();


}
