package ec.edu.ec.examen_rec.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_bodega")
	@SequenceGenerator(name ="seq_bodega",sequenceName="seq_bodega",allocationSize = 1)
	@Column(name = "bode_id")
	private Integer id;

	@Column(name = "bode_nombre")
	private String nombre;

	@Column(name = "bode_numero")
	private String numero;

	@Column(name = "bode_direccion")
	private String direccion;

	@Column(name = "bode_telefono")
	private String telefono;

	@OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL)
	private List<Producto> producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	

}