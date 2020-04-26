package com.example.demo.services;

import com.example.demo.entities.Model;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ModelService {

    @Autowired
    public ModelRepository modelRepository;

    public Integer insertModel(Model model){

        return modelRepository.save(model).getId();
    }

    public List<Model> findAllModels(){

        return  StreamSupport
                .stream(modelRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
