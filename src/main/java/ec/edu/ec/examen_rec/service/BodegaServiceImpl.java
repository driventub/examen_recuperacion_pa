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
	private IBodegaRepo estu;
	
	@Override
	public Bodega buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estu.buscar(id);
	}

	@Override
	public List<Bodega> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estu.buscarTodos();
	}

	@Override
	public void actualizar(Bodega e) {
		this.estu.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.estu.eliminar(id);
		
	}

	@Override
	public void insertar(Bodega e) {
		this.estu.insertar(e);
		
	}

}
