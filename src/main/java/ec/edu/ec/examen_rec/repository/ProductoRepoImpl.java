package ec.edu.ec.examen_rec.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import ec.edu.ec.examen_rec.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{
	
	// private static final Logger LOG = LoggerFactory.getLogger(ProductoRepoImpl.class); 
	
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(Integer id) {
		return this.e.find(Producto.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Producto> buscarTodos() {
		TypedQuery<Producto> myTypedQuery = (TypedQuery<Producto>) this.e
				.createQuery("SELECT f FROM Producto f    ",Producto.class);
		return myTypedQuery.getResultList();
		
	}

	@Override
	@Transactional()
	public void actualizar(Producto e) {
		this.e.merge(e);
		
	}

	@Override
	@Transactional()
	public void eliminar(Integer id) {
		Producto gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	@Transactional()
	public void insertar(Producto e) {
		this.e.persist(e);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarCodigo(String codigo) {
		TypedQuery<Producto> myTypedQuery = (TypedQuery<Producto>) this.e
				.createQuery("SELECT f FROM Producto f  WHERE f.codigoMaestro =:codigo   ",Producto.class).
				setParameter("codigo", codigo);
				
		return myTypedQuery.getSingleResult();
	}

}
