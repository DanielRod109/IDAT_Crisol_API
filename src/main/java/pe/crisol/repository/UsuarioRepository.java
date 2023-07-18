package pe.crisol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.crisol.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
