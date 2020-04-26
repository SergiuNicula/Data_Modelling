package com.example.demo.controllers;

import com.example.demo.entities.Model;
import com.example.demo.entities.ModelType;
import com.example.demo.services.ModelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/modelType")
public class ModelTypeController {

    @Autowired
    public ModelTypeService modelTypeService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddModelTypeForm(@RequestBody(required = false) ModelType modelType){
        return modelTypeService.insertModelType(modelType);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ModelType> displayAllModelTypes(){
        return modelTypeService.findAllModelTypes();
    }

}
