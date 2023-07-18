package pe.crisol.service;

import java.util.Collection;

import pe.crisol.entity.Libro2;

public interface Libro2Service {
	
    public abstract void insert(Libro2 libro);

    public abstract void update(Libro2 libro);

    public abstract void delete(Integer id_libro);

    public abstract Libro2 findById(Integer id_libro);

    public abstract Collection<Libro2> findAll();

    public abstract Collection<Libro2> buscarPorNombre(String nombre);
    
    public abstract Collection<Libro2> buscarPorAutor(String autor);
    
    public abstract Collection<Libro2> buscarPorEditorial(String editorial);
    

}
