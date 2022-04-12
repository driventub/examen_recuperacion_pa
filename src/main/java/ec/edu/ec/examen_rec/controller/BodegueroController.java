package ec.edu.ec.examen_rec.controller;

import java.util.List;

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

		return "lista";
	}

    // 1.c

    @GetMapping("/inventarioNuevo")

    public String obtenerInventario(Inventario inventario){
        return "inventario_obtener";
    }

    @GetMapping("registrarInventario")
    public String registrarInventario(Inventario inventario, BindingResult result, Model modelo,
    RedirectAttributes redirectAttrs){

		for(Integer i = 0; i <= inventario.getProducto().getStock(); i++){
			this.gestorService.ingresarProductos(inventario.getBodega().getNumero(), inventario.getProducto().getCodigoMaestro(),
			i);
		}
       
        
        return "inventario_registrar"; 

    }


    // 1.d

    
	@GetMapping("buscar")
	
	public String buscarTodos(Model modelo) {
		List<Producto> listaProductos = this.productoService.buscarTodos();
		modelo.addAttribute("listaProductos", listaProductos);
		return "lista";
	}

    

    @DeleteMapping("verificarProducto/{idProducto}")
	public String verificarProducto(@PathVariable("idProducto") Integer idProducto, Model modelo) {
        Producto producto = this.productoService.buscar(idProducto);
        // Si el stock es igual a 0, significa que no se ha agregado ningun producto al inventario
        
        modelo.addAttribute("producto", producto);
       


		return "producto_verificar";
	}
    @DeleteMapping("eliminar/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto") Integer idProducto, Model modelo) {
		
        
        this.productoService.eliminar(idProducto);


		return "producto_borrado";
	}


}
