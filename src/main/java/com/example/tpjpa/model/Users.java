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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "users")
    private List<Logs> logsList;

    @ManyToMany
    private List<Groups> groups;

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Users(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
