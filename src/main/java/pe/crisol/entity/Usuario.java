package pe.crisol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer usuarioId;
	
	@Column(nullable=false, length=100)
	private String nombre_trabajador;
	
	@Column(nullable=false, length=8)
	private String dni;
	
	@Column(length=12)
	private String telefono;
	
	@Column(nullable=false, length=100)
	private String email;
	
	@Column(nullable=false, length=255)
	private String password;
	
	@Column(length=10)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="rol_id",nullable = false)
	private Rol rol;
	
	/*
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
	@JsonIgnore
	private Collection<Venta> itemsVentaU = new ArrayList<>();
	*/
	public Usuario() {
	}

	

	public Usuario(Integer usuarioId, String nombre_trabajador, String dni, String telefono, String email,
			String password, String estado) {
		this.usuarioId = usuarioId;
		this.nombre_trabajador = nombre_trabajador;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.estado = estado;
	}



	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre_trabajador() {
		return nombre_trabajador;
	}

	public void setNombre_trabajador(String nombre_trabajador) {
		this.nombre_trabajador = nombre_trabajador;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
}
