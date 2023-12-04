package com.isitcom.formationSpringboot.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "categorie", cascade={CascadeType.PERSIST})
    private List<Produit> liste;

    @PreRemove
    private void preRemove() {
        liste.forEach(produit -> produit.setCategorie(null));
    }
}
