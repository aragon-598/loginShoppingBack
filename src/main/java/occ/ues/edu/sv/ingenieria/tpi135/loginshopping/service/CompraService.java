package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Compra;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.repository.CompraRepository;

@Service
public class CompraService {
    
    @Autowired
    CompraRepository compraRepository;

    public void addCompra(Compra compra){
        compraRepository.insert(compra);
    }

    public void updateCompra(Compra compra){
        
        Compra comprita = compraRepository.findById(compra.getId()).
        orElseThrow(()-> new RuntimeException("No existe esa compra"));
        
        comprita.setUsername(compra.getUsername());
        comprita.setId_producto(compra.getId_producto());
        comprita.setCantidad(compra.getCantidad());

        compraRepository.save(comprita);
    }

    public ArrayList<Compra> getAll(){
        return (ArrayList<Compra>) compraRepository.findAll();
    }

    public Compra getById(String id){
        return compraRepository.findById(id).get();
    }

    public void deleteCompra(String id){
        compraRepository.deleteById(id);
    }
}
