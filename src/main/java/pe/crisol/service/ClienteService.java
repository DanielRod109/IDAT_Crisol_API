package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Cliente;

public interface ClienteService {

	public abstract void crear(Cliente cliente);
	public abstract void actualizar(Cliente cliente);
	public abstract void eliminar(Integer clienteId);
	public abstract Cliente buscar(Integer clienteId);
	public abstract Collection<Cliente> listar();
	
}
