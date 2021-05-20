package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Compra;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Producto;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.service.CompraService;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.service.ProductoService;

@RestController
@RequestMapping("/compra")
@CrossOrigin
public class CompraController {
    
    @Autowired
    CompraService compraService;

    @Autowired
    ProductoService productoService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(compraService.getAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable String id){
        return ResponseEntity.ok(compraService.getById(id));
    }

    @PostMapping("/nuevaCompra")
    public ResponseEntity newCompra(@RequestBody Compra compra){
        try {
            Producto productito = productoService.findById(compra.getId_producto());

            if (productito != null) {
                //Obtengo la cantidad de productos
                int cant =compra.getCantidad();
                //obtengo el precio
                float price = productito.getPrecio();

                int stock = productito.getStock()-cant;

                //modifico del stock según la compra
                productito.setStock(stock);
                //guardo cambios en producto
                productoService.updateProducto(productito);

                //agrego el total calculado
                compra.setTotal(price*cant);
                compraService.addCompra(compra);
                return ResponseEntity.status(HttpStatus.CREATED).build();       
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/updateCompra")
    public ResponseEntity updateCompra(@RequestBody Compra compra){
        
        try {
            Producto productito = productoService.findById(compra.getId_producto());

            if (productito != null) {
                compraService.updateCompra(compra);
                return ResponseEntity.ok().build();       
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/deleteCompra/{id}")
    public ResponseEntity deleteCompra(@PathVariable String id){
        compraService.deleteCompra(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
