package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Permiso;
import pe.crisol.repository.PermisoRepository;
import pe.crisol.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService{

	@Autowired
	PermisoRepository repository;
	
	@Override
	@Transactional
	public void crear(Permiso permiso) {
		repository.save(permiso);
		
	}

	@Override
	@Transactional
	public void actualizar(Permiso permiso) {
		repository.save(permiso);
	}

	@Override
	@Transactional
	public void eliminar(Integer permisoId) {
		repository.deleteById(permisoId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Permiso buscar(Integer permisoId) {
		return repository.findById(permisoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Permiso> listar() {
		return repository.findAll();
	}

}
