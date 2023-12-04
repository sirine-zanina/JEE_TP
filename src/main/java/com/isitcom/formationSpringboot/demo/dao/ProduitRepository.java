package com.isitcom.formationSpringboot.demo.dao;

import com.isitcom.formationSpringboot.demo.entities.Categorie;
import com.isitcom.formationSpringboot.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // with derived queries
    List<Produit> findByNomContains(String name);

    // with jpql
    @Query("select p from Produit p where p.nom like %:x%")
    List<Produit> rechercherMC(@Param("x") String mc);


}
