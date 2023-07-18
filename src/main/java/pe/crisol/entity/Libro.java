package pe.crisol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer libroId;
	
	@Column(nullable=false,length = 100)
	private String nombre_libro;
	
	@Column
	private double peso;
	
	@Column(nullable=false,length = 100)
	private String editorial;
	
	@Column
	private double ancho;
	
	@Column
	private double alto;
	
	@Column
	private int anioEdicion;
	
	@Column
	private int npaginas;
	
	@Column(length = 255)
	private String sinopsis;
	
	@Column(length = 10)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="subgenero_id",nullable=false)
	private Subgenero subgenero;
	
	@ManyToOne
	@JoinColumn(name="autor_id",nullable=false)
	private Autor autor;
	
	public Libro() {
	}

	

	public Libro(Integer libroId, String nombre_libro, double peso, String editorial, double ancho, double alto,
			int anioEdicion, int npaginas, String sinopsis, String estado) {
		this.libroId = libroId;
		this.nombre_libro = nombre_libro;
		this.peso = peso;
		this.editorial = editorial;
		this.ancho = ancho;
		this.alto = alto;
		this.anioEdicion = anioEdicion;
		this.npaginas = npaginas;
		this.sinopsis = sinopsis;
		this.estado = estado;
	}


	public Integer getLibroId() {
		return libroId;
	}

	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}
	
	

	public String getNombre_libro() {
		return nombre_libro;
	}



	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}



	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}
	
	public int getAnioEdicion() {
		return anioEdicion;
	}

	public void setAnioEdicion(int anioEdicion) {
		this.anioEdicion = anioEdicion;
	}
	
	public int getNpaginas() {
		return npaginas;
	}

	public void setNpaginas(int npaginas) {
		this.npaginas = npaginas;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Subgenero getSubgenero() {
		return subgenero;
	}

	public void setSubgenero(Subgenero subgenero) {
		this.subgenero = subgenero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
}
