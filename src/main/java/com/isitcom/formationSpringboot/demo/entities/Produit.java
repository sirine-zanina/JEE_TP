package com.isitcom.formationSpringboot.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;
    private Long quantite;

    @ManyToOne
    @JoinColumn(name="categorie_id", nullable = true)
    private Categorie categorie;

}
