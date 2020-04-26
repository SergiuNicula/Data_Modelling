package com.example.demo.services;


import com.example.demo.entities.DataSetStructure;
import com.example.demo.repositories.DataSetStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DataSetStructureService {

    @Autowired
    public DataSetStructureRepository dataSetStructureRepository;

    public Integer insertDataSetStructure(DataSetStructure dataSetStructure){

        return dataSetStructureRepository.save(dataSetStructure).getId();
    }

    public List<DataSetStructure> findAllDataSetStructures(){

        return  StreamSupport
                .stream(dataSetStructureRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
