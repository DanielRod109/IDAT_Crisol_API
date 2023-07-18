package pe.crisol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.crisol.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
