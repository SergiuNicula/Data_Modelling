package com.example.demo.controllers;

import com.example.demo.entities.DataSet;
import com.example.demo.services.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/dataSet")
public class DataSetController {

    @Autowired
    public DataSetService dataSetService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddDataSetForm(@RequestBody(required = false) DataSet dataSet){
        return dataSetService.insertDataSet(dataSet);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DataSet> displayAllDataSets(){
        return dataSetService.findAllDataSets();
    }

}
