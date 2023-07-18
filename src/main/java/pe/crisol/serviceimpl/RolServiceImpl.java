package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Rol;
import pe.crisol.repository.RolRepository;
import pe.crisol.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	RolRepository repository;
	
	@Override
	@Transactional
	public void crear(Rol rol) {
		repository.save(rol);
		
	}

	@Override
	@Transactional
	public void actualizar(Rol rol) {
		repository.save(rol);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer rolId) {
		repository.deleteById(rolId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Rol buscar(Integer rolId) {
		return repository.findById(rolId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Rol> listar() {
		return repository.findAll();
	}

}
