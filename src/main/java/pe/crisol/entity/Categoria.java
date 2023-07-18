package pe.crisol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoriaId;
	
	@Column(nullable=false,length = 50)
	private String nombre;
	
	@Column(length = 10)
	private String estado;
	
	@OneToMany(mappedBy="categoria")
	private Collection<Genero>itemsGenero= new ArrayList<>();
	
	public Categoria() {
	}

	public Categoria(Integer categoriaId, String nombre, String estado) {
		this.categoriaId = categoriaId;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
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

	public Collection<Genero> getItemsGenero() {
		return itemsGenero;
	}

	public void setItemsGenero(Collection<Genero> itemsGenero) {
		this.itemsGenero = itemsGenero;
	}
	
	
	
	
}
