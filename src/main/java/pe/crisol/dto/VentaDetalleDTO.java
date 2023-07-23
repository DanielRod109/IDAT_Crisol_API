package pe.crisol.dto;

import java.util.List;

import pe.crisol.entity.DetalleVenta;
import pe.crisol.entity.Venta;

public class VentaDetalleDTO {
	
	
	private Venta venta;
	
	private List<DetalleVenta> detalles;
	
	public VentaDetalleDTO() {
	}
	
	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
	

}
