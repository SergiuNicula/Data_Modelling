package com.example.demo.services;

import com.example.demo.entities.Concept;
import com.example.demo.repositories.ConceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ConceptService {

    @Autowired
    public ConceptRepository conceptRepository;

    public Integer insertConcept(Concept concept){

        return conceptRepository.save(concept).getId();
    }

    public List<Concept> findAllConcepts(){

        return  StreamSupport
                .stream(conceptRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
