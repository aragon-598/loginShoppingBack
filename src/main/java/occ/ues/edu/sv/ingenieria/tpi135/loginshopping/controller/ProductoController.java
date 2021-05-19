package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Producto;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable String id){
        return ResponseEntity.ok(productoService.findById(id));
    }

    @PostMapping("/nuevoProducto")
    public ResponseEntity newCompra(@RequestBody Producto producto){
        productoService.addProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updateProducto")
    public ResponseEntity updateCompra(@RequestBody Producto producto){
        boolean ok =productoService.updateProducto(producto);
        if(ok)
            return ResponseEntity.ok().build();
        
        return ResponseEntity.notFound().build();  
    }

    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity deleteCompra(@PathVariable String id){
        boolean ok =productoService.deleteProducto(id);
        if (ok) 
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
        return ResponseEntity.notFound().build();
    }
}
