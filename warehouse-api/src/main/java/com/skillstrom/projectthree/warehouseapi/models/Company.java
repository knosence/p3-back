package com.skillstrom.projectthree.warehouseapi.models;

import lombok.*;
import lombok.extern.java.Log;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Log
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", updatable = false)
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Warehouse> warehouse;

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", location=" + location +
                ", warehouse=" + warehouse +
                '}';
    }

}
