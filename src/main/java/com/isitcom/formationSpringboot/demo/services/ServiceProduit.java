package com.isitcom.formationSpringboot.demo.services;

import com.isitcom.formationSpringboot.demo.dao.ProduitRepository;
import com.isitcom.formationSpringboot.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduit implements IServiceProduit{

    private final ProduitRepository produitRepository;

    @Autowired
    public ServiceProduit(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    @Override
    public void addProduct(Produit p) {
        produitRepository.save(p);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Produit> updateProduct(Produit p) {
        return ResponseEntity.ok(produitRepository.save(p));
    }

    @Override
    public Produit getProduct(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProductsBMC(String mc) {
        return produitRepository.findByNomContains(mc);
    }

}
