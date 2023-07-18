package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Subgenero;

public interface SubgeneroService {

	public abstract void crear(Subgenero subgenero);
	public abstract void actualizar(Subgenero subgenero);
	public abstract void eliminar(Integer subgeneroId);
	public abstract Subgenero buscar(Integer subgeneroId);
	public abstract Collection<Subgenero> listar();
	
}
