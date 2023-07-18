package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Usuario;


public interface UsuarioService {
	public abstract void crear(Usuario usuario);
	public abstract void actualizar(Usuario usuario);
	public abstract void eliminar(Integer usuarioId);
	public abstract Usuario buscar(Integer usuarioId);
	public abstract Collection<Usuario> listar();
}
