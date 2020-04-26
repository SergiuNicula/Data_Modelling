package com.example.demo.controllers;

import com.example.demo.entities.DataSetStructure;
import com.example.demo.services.DataSetStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/dataSetStructure")
public class DataSetStructureController {

    @Autowired
    public DataSetStructureService dataSetStructureService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddDataSetStructureForm(@RequestBody(required = false) DataSetStructure dataSetStructure){
        return dataSetStructureService.insertDataSetStructure(dataSetStructure);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DataSetStructure> displayAllDataSetStructures(){
        return dataSetStructureService.findAllDataSetStructures();
    }

}
