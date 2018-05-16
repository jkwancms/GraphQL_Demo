package com.example.DemoGraphQL.model;

import javax.persistence.*;

@Entity
public class Gateway {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String type;

    //Constructors
    public Gateway(){}

    public Gateway(String type) {
        this.type = type;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gateway gateway = (Gateway) o;

        if (id != null ? !id.equals(gateway.id) : gateway.id != null) return false;
        return type != null ? type.equals(gateway.type) : gateway.type == null;
    }

    @Override
    public String toString() {
        return "Gateway{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}