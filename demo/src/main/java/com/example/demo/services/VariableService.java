package com.example.demo.services;

import com.example.demo.entities.Concept;
import com.example.demo.entities.Variable;
import com.example.demo.repositories.VariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VariableService {

    @Autowired
    public VariableRepository variableRepository;

    public Integer insertVariable(Variable concept){

        return variableRepository.save(concept).getId();
    }

    public List<Variable> findAllVariables(){

        return  StreamSupport
                .stream(variableRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
