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
import javax.persistence.Table;

@Entity
@Table(name="permiso")
public class Permiso implements Serializable
{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer permisoId;
	@Column(nullable=false, length=100)
	private String permiso;
	
	
	@ManyToMany
	@JoinTable(name = "permiso_rol",
			joinColumns = @JoinColumn(name="permiso_id"),
			inverseJoinColumns = @JoinColumn(name="rol_id"))
	private Set<Rol> itemsRol = new HashSet<>();
	
	
	public Permiso() {
		
	}


	public Permiso(Integer permisoId, String permiso) {
		this.permisoId = permisoId;
		this.permiso = permiso;
	}


	public Integer getPermisoId() {
		return permisoId;
	}

	public void setPermisoId(Integer permisoId) {
		this.permisoId = permisoId;
	}



	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	
	
	
}
