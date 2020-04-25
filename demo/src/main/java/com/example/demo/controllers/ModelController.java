package com.example.demo.controllers;

import com.example.demo.entities.Model;
import com.example.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/model")
public class ModelController {

    @Autowired
    public ModelService modelService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddModelForm(@RequestBody(required = false) Model model){
        return modelService.insertModel(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Model> displayAllModels(){
        return modelService.findAllModels();
    }

}
