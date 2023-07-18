package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Rol;


public interface RolService {
	public abstract void crear(Rol rol);
	public abstract void actualizar(Rol rol);
	public abstract void eliminar(Integer rolId);
	public abstract Rol buscar(Integer rolId);
	public abstract Collection<Rol> listar();
}
