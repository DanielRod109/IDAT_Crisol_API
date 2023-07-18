package pe.crisol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.crisol.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
}
