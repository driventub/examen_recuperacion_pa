package ec.edu.ec.examen_rec.repository;

import java.util.List;

import ec.edu.ec.examen_rec.modelo.Bodega;

public interface IBodegaRepo {
	public Bodega buscar(Integer id);
	public Bodega buscarNumero(String numBodega);
	public List<Bodega> buscarTodos();
	public void actualizar(Bodega e);
	public void eliminar(Integer id);
	public void insertar(Bodega e);
}