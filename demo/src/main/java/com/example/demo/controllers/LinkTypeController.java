package com.example.demo.controllers;

import com.example.demo.entities.LinkType;
import com.example.demo.services.LinkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/linkType")
public class LinkTypeController {

    @Autowired
    public LinkTypeService linkTypeService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddLinkTypeForm(@RequestBody(required = false) LinkType linkType){
        return linkTypeService.insertLinkType(linkType);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<LinkType> displayAllLinkTypes(){
        return linkTypeService.findAllLinkTypes();
    }

}
