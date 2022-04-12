package ec.edu.ec.examen_rec.service;

import java.util.List;

import ec.edu.ec.examen_rec.modelo.Producto;

public interface IProductoService {
	public Producto buscar(Integer id);
	public List<Producto> buscarTodos();
	public void actualizar(Producto e);
	public void eliminar(Integer id);
	public void insertar(Producto e);
}
