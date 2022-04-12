package ec.edu.ec.examen_rec.repository;

import java.util.List;

import ec.edu.ec.examen_rec.modelo.Producto;

public interface IProductoRepo {
	public Producto buscar(Integer id);
	public Producto buscarCodigo(String codigo);
	public List<Producto> buscarTodos();
	public void actualizar(Producto e);
	public void eliminar(Integer id);
	public void insertar(Producto e);
}
