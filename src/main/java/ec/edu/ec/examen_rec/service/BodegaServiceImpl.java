package ec.edu.ec.examen_rec.service;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ec.examen_rec.modelo.Bodega;
import ec.edu.ec.examen_rec.repository.IBodegaRepo;

@Service
public class BodegaServiceImpl implements IBodegaService {
	
	// private static final Logger LOG = LoggerFactory.getLogger(BodegaServiceImpl.class); 

	@Autowired
	private IBodegaRepo bodegaRepo;
	
	@Override
	public Bodega buscar(Integer id) {
		
		return this.bodegaRepo.buscar(id);
	}

	@Override
	public List<Bodega> buscarTodos() {
		
		return this.bodegaRepo.buscarTodos();
	}

	@Override
	public void actualizar(Bodega e) {
		this.bodegaRepo.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.bodegaRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Bodega e) {
		this.bodegaRepo.insertar(e);
		
	}

	@Override
	public Bodega buscarNumero(String numBodega) {
		
		return this.bodegaRepo.buscarNumero(numBodega);
	}

}
