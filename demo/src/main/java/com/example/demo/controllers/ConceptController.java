package com.example.demo.controllers;

import com.example.demo.entities.Concept;
import com.example.demo.services.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ConceptController {

    @Autowired
    public ConceptService conceptService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddConceptForm(@RequestBody(required = false) Concept concept){
        return conceptService.insertConcept(concept);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Concept> displayAllConcepts(){
        return conceptService.findAllConcepts();
    }

}
