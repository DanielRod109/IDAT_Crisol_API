package pe.crisol.mapper;

import pe.crisol.entity.Usuario;

public class UsuarioMapper {

	private Integer usuarioId;
	
	private String nombre_trabajador;
	
	private String dni;
	
	private String telefono;
	
	private String email;
	
	private String estado;
	
	private String rol;
	
	public UsuarioMapper(Usuario usuario) {
		this(usuario.getUsuarioId(),usuario.getNombre_trabajador(),usuario.getDni(),
				usuario.getTelefono(),usuario.getEmail(),
				usuario.getEstado(),usuario.getRol().getNombre_rol());
	}
	
	public UsuarioMapper() {
	}

	public UsuarioMapper(Integer usuarioId, String nombre_trabajador, String dni, String telefono, String email, String estado, String rol) {
		this.usuarioId = usuarioId;
		this.nombre_trabajador = nombre_trabajador;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
		this.rol = rol;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
