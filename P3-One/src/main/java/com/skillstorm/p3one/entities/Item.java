package com.skillstorm.p3one.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Integer id;

    @Column(name = "item_name", nullable = false, length = 40)
    private String itemName;

    @Column(name = "item_description", nullable = false)
    private String itemDescription;

    @Column(name = "item_size", nullable = false)
    private Byte itemSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Byte getItemSize() {
        return itemSize;
    }

    public void setItemSize(Byte itemSize) {
        this.itemSize = itemSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(getId(), item.getId()) && Objects.equals(getItemName(), item.getItemName()) && Objects.equals(getItemDescription(), item.getItemDescription()) && Objects.equals(getItemSize(), item.getItemSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemName(), getItemDescription(), getItemSize());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemSize=" + itemSize +
                '}';
    }
}