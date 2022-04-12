package ec.edu.ec.examen_rec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.ec.examen_rec.modelo.Bodega;
import ec.edu.ec.examen_rec.modelo.Inventario;
import ec.edu.ec.examen_rec.modelo.Producto;
import ec.edu.ec.examen_rec.service.IBodegaService;
import ec.edu.ec.examen_rec.service.IGestorService;
import ec.edu.ec.examen_rec.service.IProductoService;

@Controller
@RequestMapping("/bodeguero")
public class BodegueroController {
    
    @Autowired
    private IBodegaService bodegaService;
    
    @Autowired
    private IProductoService productoService;

    @Autowired
    private IGestorService gestorService;

    // 1.a
    
	@GetMapping("/bodegaNueva")
	
	public String obtenerBodega(Bodega bodega) {
		return "bodega_nueva";

	}

	@PostMapping("/insertarBodega")
	public String insertarBodega(Bodega bodega, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        
		this.bodegaService.insertar(bodega);

		return "redirect:/bodeguero/bodegaNueva";
	}

    // 1.b
    
	@GetMapping("/productoNuevo")
	
	public String obtenerProducto(Producto producto) {
		return "producto_nuevo";

	}

	@PostMapping("/insertarProducto")
	public String insertarProducto(Producto producto, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        producto.setStock(0);
		this.productoService.insertar(producto);

		return "listar";
	}

    // 1.c

    @GetMapping("/inventarioNuevo")

    public String obtenerInventario(Inventario inventario){
        return "inventario_obtener";
    }

    @PutMapping("registrarInventario")
    public String registrarInventario(Inventario inventario, BindingResult result, Model modelo,
    RedirectAttributes redirectAttrs){
        this.gestorService.ingresarProductos(inventario.getBodega().getNumero(), inventario.getProducto().getCodigoMaestro(),
         inventario.getProducto().getStock());
        
        return "inventario_registrar"; 

    }


    // 1.d

    @GetMapping("/buscar")
    public String buscarProducto(Producto producto, BindingResult result, Model modelo,
    RedirectAttributes redirectAttrs){
        Producto p = this.productoService.buscar(producto.getId());
        modelo.addAttribute("producto", p);
        return "listar";
    }


    @DeleteMapping("/borrar")
    public String eliminarProducto(Producto producto, BindingResult result, Model modelo,
    RedirectAttributes redirectAttrs){
        this.productoService.eliminar(producto.getId());
        return "redirect:/bodeguero/buscar";
    }


    @RequestMapping("/buscar/{idProducto}")
	@GetMapping("/buscar/{idProducto}")
	public String obtenerUsuario(@PathVariable("idProducto") Integer idProducto, Model modelo) {

		Producto produ = this.productoService.buscar(idProducto);

		modelo.addAttribute("estu", produ);
		return "estudiante";
	}

    @DeleteMapping("borrar/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto") Integer idProducto, Model modelo) {
		this.productoService.eliminar(idProducto);
//		List<Producto> listaProductos = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaProductos);
		return "redirect:/estudiantes/";
	}


}
