package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.controller;

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
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.service.CompraService;

@RestController
@RequestMapping("/compra")
@CrossOrigin
public class CompraController {
    
    @Autowired
    CompraService compraService;

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
        compraService.addCompra(compra);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updateCompra")
    public ResponseEntity updateCompra(@RequestBody Compra compra){
        compraService.updateCompra(compra);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCompra")
    public ResponseEntity deleteCompra(@PathVariable String id){
        compraService.deleteCompra(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
