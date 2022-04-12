package ec.edu.ec.examen_rec.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import ec.edu.ec.examen_rec.modelo.Inventario;

@Repository
@Transactional
public class InventarioRepoImpl implements IInventarioRepo{
	
	
	
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Inventario buscar(Integer id) {
		return this.e.find(Inventario.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Inventario> buscarTodos() {
		TypedQuery<Inventario> myTypedQuery = (TypedQuery<Inventario>) this.e
				.createQuery("SELECT f FROM Inventario f    ",Inventario.class);
		return myTypedQuery.getResultList();
		
	}

	@Override
	public void actualizar(Inventario e) {
		this.e.merge(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		Inventario gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Inventario e) {
		this.e.persist(e);
		
	}

	

}
