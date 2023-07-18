package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Permiso;


public interface PermisoService {
	public abstract void crear(Permiso permiso);
	public abstract void actualizar(Permiso permiso);
	public abstract void eliminar(Integer permisoId);
	public abstract Permiso buscar(Integer permisoId);
	public abstract Collection<Permiso> listar();
}
