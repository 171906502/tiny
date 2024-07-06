package com.zch.embd.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatToyUsageRepository extends JpaRepository<CatToyUsage,Integer>{
    
}
