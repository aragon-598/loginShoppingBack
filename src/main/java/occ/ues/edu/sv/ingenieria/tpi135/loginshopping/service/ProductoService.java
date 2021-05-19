package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.service;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.model.Producto;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    public void addProducto(Producto producto){
        productoRepository.insert(producto);
    }

    public boolean updateProducto(Producto producto){
        // Producto pexistente = productoRepository.findById(producto.getId_producto()).
        // orElseThrow(()-> new RuntimeException(String.format("No existe el producto")));
        try {
            Producto pexistente = productoRepository.findById(producto.getId_producto()).get();

            if (pexistente!=null) {
                pexistente.setNombre(producto.getNombre());
                pexistente.setPrecio(producto.getPrecio());
                pexistente.setStock(producto.getStock());  
                
                return true;
            }

            productoRepository.save(pexistente);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        return false;

        
    }

    public ArrayList<Producto> getAll(){
        return (ArrayList<Producto>)productoRepository.findAll();
    }

    public Producto findById(String id){
        return productoRepository.findById(id).get();
    }

    public boolean deleteProducto(String id){
        try {
            Producto borrar = productoRepository.findById(id).get();    
            if (borrar !=null) {
                productoRepository.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        return false;
        
    }
}
