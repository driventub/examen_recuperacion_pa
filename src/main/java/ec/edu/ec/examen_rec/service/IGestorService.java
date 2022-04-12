package ec.edu.ec.examen_rec.service;

import ec.edu.ec.examen_rec.modelo.Inventario;

public interface IGestorService {
    public Inventario ingresarProductos(String numBodega, String codigoMaestro, Integer cantidad);
}
