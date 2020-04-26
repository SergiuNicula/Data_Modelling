package com.example.demo.repositories;

import com.example.demo.entities.LinkType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LinkTypeRepository extends CrudRepository<LinkType, Integer> {
}
