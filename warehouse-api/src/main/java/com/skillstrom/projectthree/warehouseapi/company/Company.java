package com.skillstrom.projectthree.warehouseapi.company;

import com.skillstrom.projectthree.warehouseapi.location.Location;
import com.skillstrom.projectthree.warehouseapi.warehouse.Warehouse;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.Set;

@Log
@Entity
@Data
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
