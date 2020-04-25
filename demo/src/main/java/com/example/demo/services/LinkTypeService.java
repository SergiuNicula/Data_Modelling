package com.example.demo.services;

import com.example.demo.entities.Concept;
import com.example.demo.entities.LinkType;
import com.example.demo.repositories.ConceptRepository;
import com.example.demo.repositories.LinkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LinkTypeService {

    @Autowired
    public LinkTypeRepository linkTypeRepository;

    public Integer insertLinkType(LinkType linkType){

        return linkTypeRepository.save(linkType).getId();
    }

    public List<LinkType> findAllLinkTypes(){

        return  StreamSupport
                .stream(linkTypeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
