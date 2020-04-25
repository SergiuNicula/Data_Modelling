package com.example.demo.controllers;

import com.example.demo.entities.Measure;
import com.example.demo.services.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/measure")
public class MeasureController {

    @Autowired
    public MeasureService measureService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddMeasureForm(@RequestBody(required = false) Measure measure){
        return measureService.insertMeasure(measure);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Measure> displayAllMeasures(){
        return measureService.findAllMeasures();
    }

}
