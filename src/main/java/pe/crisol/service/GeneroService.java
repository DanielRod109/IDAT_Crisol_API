package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Genero;

public interface GeneroService {
	
	public abstract void crear(Genero genero);
	public abstract void actualizar(Genero genero);
	public abstract void eliminar(Integer generoId);
	public abstract Genero buscar(Integer generoId);
	public abstract Collection<Genero> listar();

}
