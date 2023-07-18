package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.crisol.entity.Libro;
import pe.crisol.repository.LibroRepository;
import pe.crisol.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroRepository repository;
	
	@Override
	public void crear(Libro libro) {
		repository.save(libro);
		
	}

	@Override
	public void actualizar(Libro libro) {
		repository.save(libro);
		
	}

	@Override
	public void eliminar(Integer libroId) {
		repository.deleteById(libroId);
		
	}

	@Override
	public Libro buscar(Integer libroId) {
		return repository.findById(libroId).orElse(null);
	}

	@Override
	public Collection<Libro> listar() {
		return repository.findAll();
	}

}
