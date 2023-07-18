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
@Table(name="autor")
public class Autor implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer autorId;
	
	@Column(nullable=false, length=50)
	private String nombre_autor;
	
	@Column(nullable=false, length=50)
	private String apellidos_autor;
	
	@Column(length=20)
	private String nacionalidad;
	
	@Column(length=10)
	private String estado;
	
	@OneToMany(mappedBy="autor")
	private Collection<Libro> itemsLibro=new ArrayList<>();
	
	public Autor() {
	}

	public Autor(Integer autorId, String nombre_autor, String apellidos_autor, String nacionalidad, String estado) {
		this.autorId = autorId;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
		this.nacionalidad = nacionalidad;
		this.estado = estado;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getApellidos_autor() {
		return apellidos_autor;
	}

	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	

}
