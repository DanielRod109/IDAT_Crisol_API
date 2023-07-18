package pe.crisol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="subgenero")
public class Subgenero implements Serializable {

private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subgeneroId;
	
	@Column(nullable=false,length = 100)
	private String nombre;
	
	@Column(length = 10)
	private String estado;
	
	
	@ManyToMany(mappedBy = "itemsSubgenero")
	private Set<Genero> itemsGenero = new HashSet<>();
	
	@OneToMany(mappedBy="subgenero")
	private Collection<Libro> itemsLibro=new ArrayList<>();
	
	
	public Subgenero() {
		
	}

	public Subgenero(Integer subgeneroId, String nombre, String estado) {
		this.subgeneroId = subgeneroId;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getSubgeneroId() {
		return subgeneroId;
	}

	public void setSubgeneroId(Integer subgeneroId) {
		this.subgeneroId = subgeneroId;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
}
