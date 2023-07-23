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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer clienteId;
	
	@Column(nullable=false,length = 8)
	private String dni;
	
	@Column(nullable=false,length = 50)
	private String apellidos;
	
	@Column(nullable=false,length = 50)
	private String nombres;
	
	@Column(length = 9)
	private String telefono;
	
	@Column(length = 200)
	private String direccion;
	
	@Column(nullable=false,length = 100)
	private String email;
	
	@Column(nullable=false,length = 255)
	private String password;
	
	@Column(length = 10)
	private String estado;
	
	public Cliente() {
	}
	
	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference
	@JsonIgnore
	private Collection<Venta> itemsVentaC = new ArrayList<>();
	
	

	public Cliente(Integer clienteId, String dni, String apellidos, String nombres, String telefono, String direccion,
			String email, String password, String estado) {
		this.clienteId = clienteId;
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.password = password;
		this.estado = estado;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	
	

}
