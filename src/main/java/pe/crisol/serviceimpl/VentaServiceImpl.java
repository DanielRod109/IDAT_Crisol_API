package pe.crisol.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.crisol.entity.Venta;
import pe.crisol.repository.VentaRepository;
import pe.crisol.service.VentaService;
@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository vr;
	
	
	@Override
	public Venta buscar(Integer ventaId) {
		return vr.findById(ventaId).orElse(null);
	}
	

	@Override
	public Collection<Venta> listartotal() {
		return vr.findAll();
	}

	@Override
	public Collection<Venta> listarcliente(Integer clienteId) {
		return vr.obtenerVentasCliente(clienteId);
	}

}
