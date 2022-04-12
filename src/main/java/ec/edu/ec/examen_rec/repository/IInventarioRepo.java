package ec.edu.ec.examen_rec.repository;

import java.util.List;

import ec.edu.ec.examen_rec.modelo.Inventario;

public interface IInventarioRepo {
	public Inventario buscar(Integer id);
	public List<Inventario> buscarTodos();
	public void actualizar(Inventario e);
	public void eliminar(Integer id);
	public void insertar(Inventario e);
	
}
