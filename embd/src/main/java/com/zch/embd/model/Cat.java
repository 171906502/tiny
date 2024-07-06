package com.zch.embd.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Cat implements Serializable {
    @Id
    @GeneratedValue
    private Long catId;

    private String name;

    @OneToMany(mappedBy="id.cat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CatToyUsage> toyUsages =new HashSet<>();

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CatToyUsage> getToyUsages() {
        return toyUsages;
    }

    public void setToyUsages(Set<CatToyUsage> toyUsages) {
        this.toyUsages = toyUsages;
    }

    

    // Getters + setters
}

