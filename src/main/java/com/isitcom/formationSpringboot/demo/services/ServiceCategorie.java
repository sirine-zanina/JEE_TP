package com.isitcom.formationSpringboot.demo.services;

import com.isitcom.formationSpringboot.demo.dao.CategorieRepository;
import com.isitcom.formationSpringboot.demo.dao.ProduitRepository;
import com.isitcom.formationSpringboot.demo.entities.Categorie;
import com.isitcom.formationSpringboot.demo.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie  {

    private CategorieRepository categorieRepository;
    private final ProduitRepository produitRepository;

    @Override
    public void addCategorie(Categorie c) {
        categorieRepository.save(c);
    }

    @Override
    public void updateCategorie(Categorie c) {
        categorieRepository.save(c);
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }
    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
    @Override
    public List<Categorie> getCategoriePMC(String mc) {
        return categorieRepository.findByNomContains(mc);
    }
}
