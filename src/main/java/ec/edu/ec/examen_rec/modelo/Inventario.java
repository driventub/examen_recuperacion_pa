package ec.edu.ec.examen_rec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "inventario")
public class Inventario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_inventario")
	@SequenceGenerator(name ="seq_inventario",sequenceName="seq_inventario",allocationSize = 1)
	@Column(name = "inve_id")
	private Integer id;

	@Column(name = "inve_cod_ind")
	private String codigoIndividual;

	@Column(name = "inve_hilo")
	private String hiloNOmbre;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "bode_id")
	private Bodega bodega;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoIndividual() {
		return codigoIndividual;
	}

	public void setCodigoIndividual(String codigoIndividual) {
		this.codigoIndividual = codigoIndividual;
	}

	public String getHiloNOmbre() {
		return hiloNOmbre;
	}

	public void setHiloNOmbre(String hiloNOmbre) {
		this.hiloNOmbre = hiloNOmbre;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	


}