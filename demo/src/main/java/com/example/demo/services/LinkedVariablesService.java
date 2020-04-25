package com.example.demo.services;

import com.example.demo.entities.LinkedVariables;
import com.example.demo.repositories.LinkedVariablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LinkedVariablesService {

    @Autowired
    public LinkedVariablesRepository linkedVariablesService;

    public Integer insertLinkedVariable(LinkedVariables linkedVariables){

        return linkedVariablesService.save(linkedVariables).getId();
    }

    public List<LinkedVariables> findAllLinkedVariables(){

        return  StreamSupport
                .stream(linkedVariablesService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
