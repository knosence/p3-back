package com.skillstorm.p3one.entities;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "warehouse")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "warehouse_capacity", nullable = false)
    private Integer warehouseCapacity;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(getId(), warehouse.getId()) && Objects.equals(getLocation(), warehouse.getLocation()) && Objects.equals(getWarehouseCapacity(), warehouse.getWarehouseCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocation(), getWarehouseCapacity());
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", location=" + location +
                ", warehouseCapacity=" + warehouseCapacity +
                '}';
    }
}