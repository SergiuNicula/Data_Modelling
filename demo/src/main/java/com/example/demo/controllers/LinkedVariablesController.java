package com.example.demo.controllers;

import com.example.demo.entities.LinkedVariables;
import com.example.demo.services.LinkedVariablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/linkedVariable")
public class LinkedVariablesController {

    @Autowired
    public LinkedVariablesService linkedVariablesService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddLinkedVariableForm(@RequestBody(required = false) LinkedVariables linkedVariables){
        return linkedVariablesService.insertLinkedVariable(linkedVariables);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<LinkedVariables> displayAllLinkedVariables(){
        return linkedVariablesService.findAllLinkedVariables();
    }

}
