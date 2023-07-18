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
@Table(name="rol")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rolId;
	@Column(nullable=false,length = 20)
	private String nombre_rol;
	@Column(length = 200)
	private String descripcion;
	
	@OneToMany(mappedBy="rol")
	private Collection<Usuario>itemsUsuario= new ArrayList<>();
	
	@ManyToMany(mappedBy = "itemsRol")
	private Set<Permiso> itemsPermiso= new HashSet<>();
	
	
	public Rol() {
	}


	public Rol(Integer rolId, String nombre_rol, String descripcion) {
		this.rolId = rolId;
		this.nombre_rol = nombre_rol;
		this.descripcion = descripcion;
	}


	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Collection<Usuario> getItemsUsuario() {
		return itemsUsuario;
	}


	public void setItemsUsuario(Collection<Usuario> itemsUsuario) {
		this.itemsUsuario = itemsUsuario;
	}


	public Set<Permiso> getItemsPermiso() {
		return itemsPermiso;
	}


	public void setItemsPermiso(Set<Permiso> itemsPermiso) {
		this.itemsPermiso = itemsPermiso;
	}


	
}
