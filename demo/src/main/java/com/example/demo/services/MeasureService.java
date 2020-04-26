package com.example.demo.services;

import com.example.demo.entities.Measure;
import com.example.demo.repositories.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MeasureService {

    @Autowired
    public MeasureRepository measureRepository;

    public Integer insertMeasure(Measure measure){

        return measureRepository.save(measure).getId();
    }

    public List<Measure> findAllMeasures(){

        return  StreamSupport
                .stream(measureRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
