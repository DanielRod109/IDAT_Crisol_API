package pe.crisol.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="Venta")
public class Venta implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer ventaId;
	
	@Column
	private Double total;
	@Column
	private Integer cantidad_total;
	@Column
	private String estado;
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fecha_venta;
	@Column
	private String direccion;
	@Column
	private Boolean tipo;
	
	
	@OneToMany(mappedBy="venta")
	private Collection<DetalleVenta> itemsDetalleVenta = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable =false)
	private Cliente cliente;
	
	
	public Venta() {
	}







	public Venta(Integer ventaId, Double total, Integer cantidad_total, String estado, LocalDate fecha_venta,
			String direccion, Boolean tipo) {
		this.ventaId = ventaId;
		this.total = total;
		this.cantidad_total = cantidad_total;
		this.estado = estado;
		this.fecha_venta = fecha_venta;
		this.direccion = direccion;
		this.tipo = tipo;
	}
	

	public Integer getVentaId() {
		return ventaId;
	}


	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getCantidad_total() {
		return cantidad_total;
	}

	public void setCantidad_total(Integer cantidad_total) {
		this.cantidad_total = cantidad_total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
}
