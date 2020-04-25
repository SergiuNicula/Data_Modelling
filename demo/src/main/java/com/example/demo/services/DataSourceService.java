package com.example.demo.services;

import com.example.demo.entities.DataSource;
import com.example.demo.repositories.DataSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DataSourceService {

    @Autowired
    public DataSourceRepository dataSourceRepository;

    public Integer insertDataSource(DataSource dataSource){

        return dataSourceRepository.save(dataSource).getId();
    }

    public List<DataSource> findAllDataSources(){

        return  StreamSupport
                .stream(dataSourceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
