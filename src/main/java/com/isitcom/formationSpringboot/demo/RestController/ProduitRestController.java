package com.isitcom.formationSpringboot.demo.RestController;

import com.isitcom.formationSpringboot.demo.entities.Produit;
import com.isitcom.formationSpringboot.demo.services.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProduitRestController {

    private IServiceProduit serviceProduit;

    @GetMapping("/produits")
    public List<Produit> getAllProducts(){
        return serviceProduit.getAllProducts(); // on va convertir la liste des produits en format JSON
    }

    @GetMapping("/searchproduits/{mc}")
    public List<Produit> getProductsBMC(@PathVariable String mc){
        return serviceProduit.getProductsBMC(mc);
    }

    @PostMapping("/addproduit")
    public void addProduct(@RequestBody Produit p){
        serviceProduit.addProduct(p);
    }

}
