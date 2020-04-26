package com.example.demo.controllers;

import com.example.demo.entities.Variable;
import com.example.demo.services.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/variable")
public class VariableController {

    @Autowired
    public VariableService variableService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddVariableForm(@RequestBody(required = false) Variable variable){
        return variableService.insertVariable(variable);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Variable> displayAllVariables(){
        return variableService.findAllVariables();
    }

}
