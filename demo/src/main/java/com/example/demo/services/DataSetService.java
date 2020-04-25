package com.example.demo.services;

import com.example.demo.entities.DataSet;
import com.example.demo.repositories.DataSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DataSetService {

    @Autowired
    public DataSetRepository dataSetRepository;

    public Integer insertDataSet(DataSet dataSet){

        return dataSetRepository.save(dataSet).getId();
    }

    public List<DataSet> findAllDataSets(){

        return  StreamSupport
                .stream(dataSetRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
