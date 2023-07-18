package pe.crisol.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="genero")
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer generoId;
	
	@Column(nullable=false,length = 50)
	private String nombre;
	
	@Column(length = 10)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable = false)
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="Genero_Subgenero",
		joinColumns=@JoinColumn(name="genero_id"),
		inverseJoinColumns=@JoinColumn(name="subgenero_id"))
	private Set<Subgenero> itemsSubgenero=new HashSet<>();
	
	public Genero() {
	}

	public Genero(Integer generoId, String nombre, String estado) {
		this.generoId = generoId;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Integer generoId) {
		this.generoId = generoId;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Subgenero> getItemsSubgenero() {
		return itemsSubgenero;
	}

	public void setItemsSubgenero(Set<Subgenero> itemsSubgenero) {
		this.itemsSubgenero = itemsSubgenero;
	}

	
	
	
	
}
