package ec.edu.ec.examen_rec.service;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(true)
@Transactional
public class GestorServiceImplTest {
    
    @Autowired
    private IGestorService gestor;
    
    @Test
    void testIngresarProductos() {
        this.gestor.ingresarProductos("BUIO1", "0001A", 3);
        
    }
}
