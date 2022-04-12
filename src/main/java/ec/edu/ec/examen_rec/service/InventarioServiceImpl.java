package ec.edu.ec.examen_rec.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ec.examen_rec.modelo.Inventario;
import ec.edu.ec.examen_rec.repository.IInventarioRepo;

@Service
public class InventarioServiceImpl implements IInventarioService {
	
	// private static final Logger LOG = LoggerFactory.getLogger(InventarioServiceImpl.class); 

	@Autowired
	private IInventarioRepo inventarioRepo;
	
	@Override
	public Inventario buscar(Integer id) {
		return this.inventarioRepo.buscar(id);
	}

	@Override
	public List<Inventario> buscarTodos() {
		return this.inventarioRepo.buscarTodos();
	}

	@Override
	public void actualizar(Inventario e) {
		this.inventarioRepo.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.inventarioRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Inventario e) {
		this.inventarioRepo.insertar(e);
		
	}

}
