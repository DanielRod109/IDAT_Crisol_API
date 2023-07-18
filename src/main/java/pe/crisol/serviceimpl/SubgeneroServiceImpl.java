package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Subgenero;
import pe.crisol.repository.SubgeneroRepository;
import pe.crisol.service.SubgeneroService;

@Service
public class SubgeneroServiceImpl implements SubgeneroService{

	@Autowired
	SubgeneroRepository repository;
	
	@Override
	@Transactional
	public void crear(Subgenero subgenero) {
		repository.save(subgenero);
		
	}

	@Override
	@Transactional
	public void actualizar(Subgenero subgenero) {
		repository.save(subgenero);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer subgeneroId) {
		repository.deleteById(subgeneroId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Subgenero buscar(Integer subgeneroId) {
		return repository.findById(subgeneroId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Subgenero> listar() {
		return repository.findAll();
	}
	
	

}
