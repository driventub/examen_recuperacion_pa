package ec.edu.ec.examen_rec.service;

import java.util.List;

import ec.edu.ec.examen_rec.modelo.Inventario;

public interface IInventarioService {
	public Inventario buscar(Integer id);
	public List<Inventario> buscarTodos();
	public void actualizar(Inventario e);
	public void eliminar(Integer id);
	public void insertar(Inventario e);
}
