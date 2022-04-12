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
	private IInventarioRepo estu;
	
	@Override
	public Inventario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estu.buscar(id);
	}

	@Override
	public List<Inventario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estu.buscarTodos();
	}

	@Override
	public void actualizar(Inventario e) {
		this.estu.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.estu.eliminar(id);
		
	}

	@Override
	public void insertar(Inventario e) {
		this.estu.insertar(e);
		
	}

}
