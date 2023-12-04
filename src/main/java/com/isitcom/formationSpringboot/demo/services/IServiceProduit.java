package com.isitcom.formationSpringboot.demo.services;

import com.isitcom.formationSpringboot.demo.entities.Produit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceProduit {

    public void addProduct(Produit p);
    public void deleteProduct(Long id);
    public ResponseEntity<Produit> updateProduct(Produit p);
    public Produit getProduct(Long id);
    public List<Produit> getAllProducts();
    public List<Produit> getProductsBMC(String mc);
}
