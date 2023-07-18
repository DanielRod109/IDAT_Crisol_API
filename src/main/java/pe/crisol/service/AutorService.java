package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Autor;

public interface AutorService {
	public abstract void crear(Autor autor);
	public abstract void actualizar(Autor autor);
	public abstract void eliminar(Integer autorId);
	public abstract Autor buscar(Integer autorId);
	public abstract Collection<Autor> listar();
}
