package com.zch.tiny.repository;

import com.zch.tiny.model.DataDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDictionaryRepository extends JpaRepository<DataDictionary, Integer> {
}
