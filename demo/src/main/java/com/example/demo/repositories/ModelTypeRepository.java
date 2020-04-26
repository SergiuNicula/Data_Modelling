package com.example.demo.repositories;

import com.example.demo.entities.ModelType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ModelTypeRepository extends CrudRepository<ModelType, Integer> {
}
