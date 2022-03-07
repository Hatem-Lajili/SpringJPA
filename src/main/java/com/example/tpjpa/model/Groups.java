package com.example.tpjpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "Capacite")
    private String Capacite;

    @ManyToMany
    private List<Users> users;

    public Groups(Integer id, String libelle, String capacite) {
        this.id = id;
        this.libelle = libelle;
        Capacite = capacite;
    }
}
