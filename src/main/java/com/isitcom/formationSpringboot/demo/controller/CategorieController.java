package com.isitcom.formationSpringboot.demo.controller;

import com.isitcom.formationSpringboot.demo.entities.Categorie;
import com.isitcom.formationSpringboot.demo.services.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategorieController {

    private final IServiceCategorie serviceCategorie;

    @Autowired
    public CategorieController(IServiceCategorie serviceCategorie){
        this.serviceCategorie = serviceCategorie;
    }

    @GetMapping("/addCategorie")
    public String showAddCategoriePage(){
        return "ajoutCat";
    }

    @PostMapping("/ajouterCategorie")
    public String ajouterCategorie(Categorie c){
        if (c.getId() == null) {
            serviceCategorie.addCategorie(c);
        } else {
            serviceCategorie.updateCategorie(c);
        }
        return "redirect:/categories";
    }
    @GetMapping("/searchCat")
    public String rechercher(@RequestParam String mc, Model m){
        List<Categorie> categories = serviceCategorie.getCategoriePMC(mc);
        m.addAttribute("categories",categories);
        return "vueCat";
    }

    @GetMapping("deleteCat/{id}")
    public String supprimerCategorie(@PathVariable Long id){
        serviceCategorie.deleteCategorie(id);
        return "redirect:/categories";
    }

    @GetMapping("updateCat/{id}")
    public String modifierCategorie(@PathVariable Long id, Model m){
        Categorie categorie = serviceCategorie.getCategorie(id);
        m.addAttribute("categorie",categorie);
        return "ajoutCat";
    }

    @GetMapping("/categories")
    public String getAllCategories(Model m){
        List<Categorie> categories = serviceCategorie.getAllCategories();
        m.addAttribute("categories", categories);
        return "vueCat";
    }





}
