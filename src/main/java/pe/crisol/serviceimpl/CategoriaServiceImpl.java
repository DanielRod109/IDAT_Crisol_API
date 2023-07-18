package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Categoria;
import pe.crisol.repository.CategoriaRepository;
import pe.crisol.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	@Transactional
	public void crear(Categoria categoria) {
		repository.save(categoria);
		
	}

	@Override
	@Transactional
	public void actualizar(Categoria categoria) {
		repository.save(categoria);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer categoriaId) {
		repository.deleteById(categoriaId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Categoria buscar(Integer categoriaId) {
		return repository.findById(categoriaId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Categoria> listar() {
		return repository.findAll();
	}

}
