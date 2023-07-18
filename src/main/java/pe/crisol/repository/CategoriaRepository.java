package pe.crisol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.crisol.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
}
