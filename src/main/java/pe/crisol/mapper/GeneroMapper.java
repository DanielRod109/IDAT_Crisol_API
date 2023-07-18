package pe.crisol.mapper;

import pe.crisol.entity.Genero;

public class GeneroMapper {

	private Integer generoId;
	
	private String nombre;
	
	private String estado;
	
	private String categoria;
	
	public GeneroMapper() {
	}
	
	public GeneroMapper(Genero genero) {
		this(genero.getGeneroId(),genero.getNombre(),
				genero.getEstado(),genero.getCategoria().getNombre());
	}

	public GeneroMapper(Integer generoId, String nombre, String estado, String categoria) {
		this.generoId = generoId;
		this.nombre = nombre;
		this.estado = estado;
		this.categoria = categoria;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
