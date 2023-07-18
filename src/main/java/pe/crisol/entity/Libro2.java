package pe.crisol.entity;

import java.io.Serializable;
import java.time.LocalDate;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

 


@Entity
@Table(name="libro2")
public class Libro2 implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_libro;

    @Column
    private String nombre;

    @Column
    private Double peso;

    @Column
    private String editorial;

    @Column
    private Double alto;

    @Column
    private Double ancho;

    @Column
    private Integer stock;

    @Column
    private Double precio;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
    private LocalDate aedicion;

    @Column
    private Integer npaginas;

    @Column
    private String autor;

    @Column
    private String img;

   
    
    
    public Libro2() {}

 

    public Libro2(Integer id_libro, String nombre, Double peso, String editorial, Double alto, Double ancho, Integer stock,
            Double precio, LocalDate aedicion, Integer npaginas, String autor,String img) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.peso = peso;
        this.editorial = editorial;
        this.alto = alto;
        this.ancho = ancho;
        this.stock = stock;
        this.precio = precio;
        this.aedicion = aedicion;
        this.npaginas = npaginas;
        this.autor = autor;
        this.img = img;
    }


    public String getImg() {
        return img;
    }

 

    public void setImg(String img) {
        this.img = img;
    }

 

    public Integer getStock() {
        return stock;
    }

 

    public void setStock(Integer stock) {
        this.stock = stock;
    }

 

    public Integer getId_libro() {
        return id_libro;
    }

 

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

 

    public String getNombre() {
        return nombre;
    }

 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 

    public Double getPeso() {
        return peso;
    }

 

    public void setPeso(Double peso) {
        this.peso = peso;
    }

 

    public String getEditorial() {
        return editorial;
    }

 

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

 

    public Double getAlto() {
        return alto;
    }

 

    public void setAlto(Double alto) {
        this.alto = alto;
    }

 

    public Double getAncho() {
        return ancho;
    }

 

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

 

    public Double getPrecio() {
        return precio;
    }

 

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

 

    public LocalDate getAedicion() {
        return aedicion;
    }

 

    public void setAedicion(LocalDate aedicion) {
        this.aedicion = aedicion;
    }

 

    public Integer getNpaginas() {
        return npaginas;
    }

 

    public void setNpaginas(Integer npaginas) {
        this.npaginas = npaginas;
    }

 

    public String getAutor() {
        return autor;
    }

 

    public void setAutor(String autor) {
        this.autor = autor;
    }        
}