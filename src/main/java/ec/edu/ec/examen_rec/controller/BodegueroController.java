package ec.edu.ec.examen_rec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.ec.examen_rec.modelo.Bodega;
import ec.edu.ec.examen_rec.modelo.Producto;
import ec.edu.ec.examen_rec.service.IBodegaService;
import ec.edu.ec.examen_rec.service.IProductoService;

@Controller
@RequestMapping("/bodeguero")
public class BodegueroController {
    
    @Autowired
    private IBodegaService bodegaService;
    
    @Autowired
    private IProductoService productoService;

    // 1.a
    
	@GetMapping("/bodegaNueva")
	// Comentario
	public String obtenerBodega(Bodega bodega) {
		return "bodega_nueva";

	}

	@PostMapping("/insertar")
	public String insertarBodega(Bodega bodega, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        
		this.bodegaService.insertar(bodega);

		return "redirect:/bodeguero/bodegaNueva";
	}

    // 1.a
    
	@GetMapping("/productoNuevo")
	// Comentario
	public String obtenerProducto(Producto producto) {
		return "producto_nuevo";

	}

	@PostMapping("/insertar")
	public String insertarProducto(Producto producto, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        producto.setStock(0);
		this.productoService.insertar(producto);

		return "lista";
	}




}
