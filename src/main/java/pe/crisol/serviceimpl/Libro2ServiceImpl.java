   package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Libro2;
import pe.crisol.repository.Libro2Repository;
import pe.crisol.service.Libro2Service;

@Service
public class Libro2ServiceImpl implements Libro2Service {

	@Autowired

    private Libro2Repository sd;

    @Override
    @Transactional
    public void insert(Libro2 libro) {
        sd.save(libro);   
    }

 

    @Override
    @Transactional
    public void update(Libro2 libro) {
        sd.save(libro);
    }

 
    @Override
    @Transactional
    public void delete(Integer id_libro) {
        sd.deleteById(id_libro);        
    }

 

    @Override
    @Transactional(readOnly=true)
    public Libro2 findById(Integer id_libro) {
        return sd.findById(id_libro).orElse(null);

    }


    @Override
    @Transactional(readOnly=true)
    public Collection<Libro2> findAll() {
        return sd.findAll();
    }
    
    @Transactional(readOnly=true)
	@Override
	public Collection<Libro2> buscarPorNombre(String nombre) {
		return sd.buscarPorNombre(nombre);
	}


    @Transactional(readOnly=true)
	@Override
	public Collection<Libro2> buscarPorAutor(String autor) {
		return sd.buscarPorAutor(autor);
	}


    @Transactional(readOnly=true)
	@Override
	public Collection<Libro2> buscarPorEditorial(String editorial) {
		return sd.buscarPorEditorial(editorial);
	}

 

}