package com.crina.model;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private String level;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(String name, String level){
        setName(name);
        setLevel(level);
    }

    public Item(Integer id, String name, String level){
        setId(id);
        setName(name);
        setLevel(level);
    }

    public Item(){

    }
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
