package ec.edu.ec.examen_rec.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.ec.examen_rec.modelo.Bodega;

@Repository
@Transactional
public class BodegaRepoImpl implements IBodegaRepo{
	
	private static final Logger LOG = Logger.getLogger(BodegaRepoImpl.class); 
	
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Bodega buscar(Integer id) {
		return this.e.find(Bodega.class, id);
	}

	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Bodega> buscarTodos() {
		TypedQuery<Bodega> myTypedQuery = (TypedQuery<Bodega>) this.e
				.createQuery("SELECT f FROM Bodega f    ",Bodega.class);
		return myTypedQuery.getResultList();
		
	}

	
	@Override
	@Transactional()
	public void actualizar(Bodega e) {
		this.e.merge(e);
		
	}

	
	@Override
	@Transactional()
	public void eliminar(Integer id) {
		Bodega gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	
	@Override
	@Transactional()
	public void insertar(Bodega e) {
		this.e.persist(e);
		
	}

	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Bodega buscarNumero(String numBodega) {
		TypedQuery<Bodega> myTypedQuery = (TypedQuery<Bodega>) this.e
		.createQuery("SELECT f FROM Bodega f  WHERE f.numero = :num  ",Bodega.class).
		setParameter("num", numBodega);
		return myTypedQuery.getSingleResult();
	}

}
