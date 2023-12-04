package com.isitcom.formationSpringboot.demo.dao;

import com.isitcom.formationSpringboot.demo.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

    // with derived queries
    List<Categorie> findByNomContains(String name);

    // with jpql
    @Query("select c from Categorie c where c.nom like %:x")
    List<Categorie> rechercherMC(@Param("x") String mc);

}
