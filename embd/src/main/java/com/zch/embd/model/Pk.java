package com.zch.embd.model;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Pk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @Column(nullable = false, updatable = false)
    private Long toyId;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Long getToyId() {
        return toyId;
    }

    public void setToyId(Long toyId) {
        this.toyId = toyId;
    }


    // Getters + setters + equals + hashCode
}
