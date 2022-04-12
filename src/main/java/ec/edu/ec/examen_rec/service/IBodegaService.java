package ec.edu.ec.examen_rec.service;

import java.util.List;

import ec.edu.ec.examen_rec.modelo.Bodega;

public interface IBodegaService {
	public Bodega buscar(Integer id);
	public List<Bodega> buscarTodos();
	public void actualizar(Bodega e);
	public void eliminar(Integer id);
	public void insertar(Bodega e);
}