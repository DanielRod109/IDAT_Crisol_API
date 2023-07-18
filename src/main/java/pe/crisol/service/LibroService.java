package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Libro;

public interface LibroService {
	
	public abstract void crear(Libro libro);
	public abstract void actualizar(Libro libro);
	public abstract void eliminar(Integer libroId);
	public abstract Libro buscar(Integer libroId);
	public abstract Collection<Libro> listar();

}
