package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Genero;
import pe.crisol.repository.GeneroRepository;
import pe.crisol.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	GeneroRepository repository;
	
	@Override
	@Transactional
	public void crear(Genero genero) {
		repository.save(genero);
		
	}

	@Override
	@Transactional
	public void actualizar(Genero genero) {
		repository.save(genero);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer generoId) {
		repository.deleteById(generoId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Genero buscar(Integer generoId) {
		return repository.findById(generoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Genero> listar() {
		return repository.findAll();
	}
	
	

}
