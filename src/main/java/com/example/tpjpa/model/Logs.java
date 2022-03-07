package com.example.tpjpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    @CreatedDate
    @Column(name = "date")
    private String date;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    public Logs(String date, String description, Users users) {
        this.date = date;
        this.description = description;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
