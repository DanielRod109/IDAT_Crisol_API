package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Categoria;

public interface CategoriaService {
	
	public abstract void crear(Categoria categoria);
	public abstract void actualizar(Categoria categoria);
	public abstract void eliminar(Integer categoriaId);
	public abstract Categoria buscar(Integer categoriaId);
	public abstract Collection<Categoria> listar();
}
