package com.zch.embd.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CatRepository extends JpaRepository<Cat,Pk>{
    
}
