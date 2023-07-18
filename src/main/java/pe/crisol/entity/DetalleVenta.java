package pe.crisol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleVenta")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer detalleventaId;
	@Column
	private Integer cantidad;
	@Column
	private Double precio_uni;
	@Column
	private Double subtotal;
	
	
	
	@ManyToOne
	@JoinColumn(name = "venta_id", nullable =false)
	private Venta venta;
	
	
	
	
	
	public DetalleVenta() {
	}

	public DetalleVenta(Integer detalleventaId, Integer cantidad, Double precio_uni, Double subtotal) {
		this.detalleventaId = detalleventaId;
		this.cantidad = cantidad;
		this.precio_uni = precio_uni;
		this.subtotal = subtotal;
	}

	public Integer getDetalleventaId() {
		return detalleventaId;
	}

	public void setDetalleventaId(Integer detalleventaId) {
		this.detalleventaId = detalleventaId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio_uni() {
		return precio_uni;
	}

	public void setPrecio_uni(Double precio_uni) {
		this.precio_uni = precio_uni;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}
