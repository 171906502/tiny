package com.zch.embd.model;

import java.io.Serializable;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class CatToyUsage implements Serializable {

    @EmbeddedId
    private Pk id;

    @Enumerated(EnumType.STRING)
    private UsageStatus usageStatus;

    public Pk getId() {
        return id;
    }

    public void setId(Pk id) {
        this.id = id;
    }

    public UsageStatus getUsageStatus() {
        return usageStatus;
    }

    public void setUsageStatus(UsageStatus usageStatus) {
        this.usageStatus = usageStatus;
    }

    

    // Getters + setters
}