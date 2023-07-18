package pe.crisol.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.crisol.entity.Libro2;

public interface Libro2Repository extends JpaRepository<Libro2, Integer>{
	
	//OR (autor = (SELECT autor FROM libro WHERE nombre = :nombre) OR editorial = (SELECT editorial FROM libro WHERE nombre = :nombre)s
	@Query(value = "SELECT * FROM libro WHERE nombre = :nombre", nativeQuery = true)
    Collection<Libro2> buscarPorNombre(@Param("nombre") String nombre);
	
	@Query(value= "SELECT * FROM libro WHERE autor = :autor", nativeQuery = true)
	 Collection<Libro2> buscarPorAutor(@Param("autor") String autor);
	
	@Query(value= "SELECT * FROM libro WHERE editorial = :editorial", nativeQuery = true)
	 Collection<Libro2> buscarPorEditorial(@Param("editorial") String editorial);

}
