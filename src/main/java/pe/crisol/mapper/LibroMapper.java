package pe.crisol.mapper;


import pe.crisol.entity.Libro;

public class LibroMapper {

	private Integer libroId;
	
	private String nombre_libro;
	
	private double peso;
	
	private String editorial;
	
	private double ancho;
	
	private double alto;
	
	private int anioEdicion;
	
	private int npaginas;

	private String sinopsis;
	
	private String estado;
	
	private String autor;
	
	private String subgenero;
	
	
	public LibroMapper() {
	}
	
	public LibroMapper(Libro libro) {
		this(libro.getLibroId(),libro.getNombre_libro(),libro.getPeso(),
				libro.getEditorial(),libro.getAncho(),libro.getAlto(),libro.getAnioEdicion(),
				libro.getNpaginas(),libro.getSinopsis(),libro.getEstado(),
				libro.getAutor().getNombre_autor()+" "+libro.getAutor().getApellidos_autor(),
				libro.getSubgenero().getNombre());
	}

	

	public LibroMapper(Integer libroId, String nombre_libro, double peso, String editorial, double ancho, double alto,
			int anioEdicion, int npaginas, String sinopsis, String estado, String autor, String subgenero) {
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
		this.autor = autor;
		this.subgenero = subgenero;
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


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getSubgenero() {
		return subgenero;
	}


	public void setSubgenero(String subgenero) {
		this.subgenero = subgenero;
	}	
	
	
	
	
	
}
