package ec.edu.ec.examen_rec.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ec.examen_rec.modelo.Bodega;
import ec.edu.ec.examen_rec.modelo.Inventario;
import ec.edu.ec.examen_rec.modelo.Producto;

@Service
public class GestorServiceImpl implements IGestorService {

    private static final Logger LOG = Logger.getLogger(GestorServiceImpl.class); 

    @Autowired
    private IInventarioService inventarioService;

    @Autowired
    private IBodegaService bodegaService;

    @Autowired
    private IProductoService productoService;


    @Override
    @Transactional
    public Inventario ingresarProductos(String numBodega, String codigoMaestro, Integer cantidad) {
        Bodega b = this.bodegaService.buscarNumero(numBodega);
        Producto p = this.productoService.buscarCodigo(codigoMaestro);
        Inventario invent = new Inventario();
        // invent.setProducto(p);
        // invent.setBodega(b);
        
        p.setBodega(b);
        

        for(Integer i = 0; i <= cantidad; i++){
            
           
            String c = p.getCodigoMaestro() + Integer.toString(i);
            invent.setCodigoIndividual(c);
            invent.setProducto(p);
            invent.setBodega(b);

            this.inventarioService.insertar(invent);
            

        }

        

        Integer resultado = p.getStock() + cantidad;
        p.setStock(resultado);
        this.productoService.actualizar(p);

        return invent;
    }
    
}
