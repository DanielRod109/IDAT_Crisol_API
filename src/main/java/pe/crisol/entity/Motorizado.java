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
@Table(name = "motorizado")
public class Motorizado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer motorizadoId;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private Integer dni;
	@Column
	private String placa;
	
	/*
	@OneToMany(mappedBy = "motorizado")
	@JsonManagedReference
	@JsonIgnore
	private Collection<Venta> itemsVentaM = new ArrayList<>();
*/
	public Motorizado() {
	}

	public Motorizado(Integer motorizadoId, String nombres, String apellidos, Integer dni, String placa) {
		this.motorizadoId = motorizadoId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.placa = placa;
	}

	public Integer getMotorizadoId() {
		return motorizadoId;
	}

	public void setMotorizadoId(Integer motorizadoId) {
		this.motorizadoId = motorizadoId;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
