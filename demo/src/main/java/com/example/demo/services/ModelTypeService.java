package com.example.demo.services;

import com.example.demo.entities.ModelType;
import com.example.demo.repositories.ModelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ModelTypeService {

    @Autowired
    public ModelTypeRepository modelTypeRepository;

    public Integer insertModelType(ModelType modelType){

        return modelTypeRepository.save(modelType).getId();
    }

    public List<ModelType> findAllModelTypes(){

        return  StreamSupport
                .stream(modelTypeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
