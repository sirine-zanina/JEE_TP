package com.isitcom.formationSpringboot.demo.controller;

import com.isitcom.formationSpringboot.demo.entities.Categorie;
import com.isitcom.formationSpringboot.demo.entities.Produit;
import com.isitcom.formationSpringboot.demo.services.IServiceCategorie;
import com.isitcom.formationSpringboot.demo.services.IServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProduitController {

    private final IServiceProduit serviceProduit;
    private final IServiceCategorie categorieService;

    @Autowired
    public ProduitController(IServiceProduit serviceProduit, IServiceCategorie categorieService){
        this.serviceProduit = serviceProduit;
        this.categorieService = categorieService;
    }

    @GetMapping("/add")
    public String showAddProduitPage(Model m){
        List<Categorie> categories = categorieService.getAllCategories();
        m.addAttribute("categories",categories);
        return "ajouter";
    }

    @PostMapping("/ajouterProduit")
    public String ajouterProduit(Produit p){
        if (p.getId() == null) {
            serviceProduit.addProduct(p);
        } else {
            serviceProduit.updateProduct(p);
        }
        return "redirect:/produits";
    }

    @GetMapping("/produits")
    public String getAllProducts(Model m){
        List<Produit> produits = serviceProduit.getAllProducts();
        m.addAttribute("produits",produits);
        return "vue";
    }

    @GetMapping("/search")
    public String rechercher(@RequestParam String mc, Model m){
        List<Produit> produits = serviceProduit.getProductsBMC(mc);
        m.addAttribute("produits",produits);
        return "vue";
    }

    @GetMapping("delete/{id}")
    public String supprimerProduit(@PathVariable Long id){
        serviceProduit.deleteProduct(id);
        return "redirect:/produits";
    }
    @GetMapping("edit/{id}")
    public String modifierProduit(@PathVariable Long id, Model m){
        Produit produit = serviceProduit.getProduct(id);
        List<Categorie> categories = categorieService.getAllCategories();
        m.addAttribute("categories",categories);
        m.addAttribute("produit",produit);

        return "ajouter";
    }



}
