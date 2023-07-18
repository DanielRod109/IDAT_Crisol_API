package pe.crisol.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.crisol.entity.Genero;
import pe.crisol.entity.Libro;
import pe.crisol.entity.Usuario;
import pe.crisol.mapper.GeneroMapper;
import pe.crisol.mapper.LibroMapper;
import pe.crisol.mapper.UsuarioMapper;


public class MapperCrisol {
	
	public static Collection<UsuarioMapper> toUsuarios(Collection<Usuario> usuarios){
			Collection<UsuarioMapper> collection = new ArrayList<>();
			
			for(Usuario usuario: usuarios) {
				
				UsuarioMapper mapper = new UsuarioMapper(usuario);
				collection.add(mapper);
			}
			
			return collection;
		}
	
	public static Collection<GeneroMapper> toGeneros(Collection<Genero> generos){
		Collection<GeneroMapper> collection = new ArrayList<>();
		
		for(Genero genero: generos) {
			
			GeneroMapper mapper = new GeneroMapper(genero);
			collection.add(mapper);
		}
		
		return collection;
	}
	
	public static Collection<LibroMapper> toLibros(Collection<Libro> libros){
		Collection<LibroMapper> collection = new ArrayList<>();
		
		for(Libro libro: libros) {
			
			LibroMapper mapper = new LibroMapper(libro);
			collection.add(mapper);
		}
		
		return collection;
	}
}
