package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.crisol.entity.Autor;
import pe.crisol.repository.AutorRepository;
import pe.crisol.service.AutorService;

@Service
public class AutorServiceImpl  implements AutorService{

	@Autowired
	AutorRepository repository;
	
	@Override
	public void crear(Autor autor) {
		repository.save(autor);
		
	}

	@Override
	public void actualizar(Autor autor) {
		repository.save(autor);
		
	}

	@Override
	public void eliminar(Integer autorId) {
		repository.deleteById(autorId);
		
	}

	@Override
	public Autor buscar(Integer autorId) {
		return repository.findById(autorId).orElse(null);
	}

	@Override
	public Collection<Autor> listar() {
		return repository.findAll();
	}

}
