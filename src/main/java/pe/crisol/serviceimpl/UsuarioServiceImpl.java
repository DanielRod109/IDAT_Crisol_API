package pe.crisol.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.Usuario;
import pe.crisol.repository.UsuarioRepository;
import pe.crisol.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;
	
	public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(password.getBytes());
            String encryptedPassword = Base64.getEncoder().encodeToString(hash);
            return encryptedPassword;
        } catch (NoSuchAlgorithmException e) {
        	return null;
        }
       
    }
	
	@Override
	@Transactional
	public void crear(Usuario usuario) {
		String passwordEncriptado = encryptPassword(usuario.getPassword());
	    usuario.setPassword(passwordEncriptado);
		repository.save(usuario);
		
	}

	@Override
	@Transactional
	public void actualizar(Usuario usuario) {
		String passwordEncriptado = encryptPassword(usuario.getPassword());
	    usuario.setPassword(passwordEncriptado);
		repository.save(usuario);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer usuarioId) {
		repository.deleteById(usuarioId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario buscar(Integer usuarioId) {
		return repository.findById(usuarioId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Usuario> listar() {
		return repository.findAll();
	}

}
