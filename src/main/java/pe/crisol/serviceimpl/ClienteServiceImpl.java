package pe.crisol.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.crisol.entity.Cliente;
import pe.crisol.repository.ClienteRepository;
import pe.crisol.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository repository;
	
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
	public void crear(Cliente cliente) {
		String passwordEncriptado = encryptPassword(cliente.getPassword());
		cliente.setPassword(passwordEncriptado);
		repository.save(cliente);
		
	}

	@Override
	@Transactional
	public void actualizar(Cliente cliente) {
		repository.save(cliente);
		
	}

	@Override
	@Transactional
	public void eliminar(Integer clienteId) {
		repository.deleteById(clienteId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente buscar(Integer clienteId) {
		return repository.findById(clienteId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Cliente> listar() {
		return repository.findAll();
	}

}
