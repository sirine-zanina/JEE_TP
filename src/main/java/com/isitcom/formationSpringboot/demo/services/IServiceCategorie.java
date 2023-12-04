package com.isitcom.formationSpringboot.demo.services;

import com.isitcom.formationSpringboot.demo.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {
    public void addCategorie(Categorie c);
    public void updateCategorie(Categorie c);
    public void deleteCategorie(Long id);
    public Categorie getCategorie(Long id);
    public List<Categorie> getAllCategories();
    public List<Categorie> getCategoriePMC(String mc);

}
