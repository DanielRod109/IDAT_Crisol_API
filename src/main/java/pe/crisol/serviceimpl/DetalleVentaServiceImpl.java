package pe.crisol.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.crisol.entity.DetalleVenta;
import pe.crisol.repository.DetalleVentaRepository;
import pe.crisol.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

	@Autowired
	private DetalleVentaRepository repo;
	
	
	
	@Override
	@Transactional
	public void crear(DetalleVenta detalleventa) {
		repo.save(detalleventa);
	}

}
