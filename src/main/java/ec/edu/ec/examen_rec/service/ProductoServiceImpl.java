package ec.edu.ec.examen_rec.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ec.examen_rec.modelo.Producto;
import ec.edu.ec.examen_rec.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	// private static final Logger LOG = LoggerFactory.getLogger(ProductoServiceImpl.class); 

	@Autowired
	private IProductoRepo estu;
	
	@Override
	public Producto buscar(Integer id) {
		
		return this.estu.buscar(id);
	}

	@Override
	public List<Producto> buscarTodos() {
		
		return this.estu.buscarTodos();
	}

	@Override
	public void actualizar(Producto e) {
		this.estu.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.estu.eliminar(id);
		
	}

	@Override
	public void insertar(Producto e) {
		this.estu.insertar(e);
		
	}

	@Override
	public Producto buscarCodigo(String codigo) {
		
		return this.estu.buscarCodigo(codigo);
	}

	
}
