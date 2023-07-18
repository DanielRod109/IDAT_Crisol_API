package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Motorizado;
import pe.crisol.repository.MotorizadoRepository;
import pe.crisol.service.MotorizadoService;

@Service
public class MotorizadoServiceImpl implements MotorizadoService {

	@Autowired
	private MotorizadoRepository repo;
		
	@Override
	@Transactional
	public void crear(Motorizado motorizado) {
		repo.save(motorizado);	
	}

	@Override
	@Transactional
	public void actualizar(Motorizado motorizado) {
		repo.save(motorizado);
	}

	@Override
	@Transactional
	public void eliminar(Integer motorizadoId) {
		repo.deleteById(motorizadoId);
	}

	@Override
	@Transactional(readOnly=true)
	public Motorizado buscar(Integer motorizadoId) {
		return repo.findById(motorizadoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Motorizado> listar() {
		return repo.findAll();
	}

}
