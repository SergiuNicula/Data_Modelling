package com.example.demo.controllers;

import com.example.demo.entities.DataSource;
import com.example.demo.services.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/dataSource")
public class DataSourceController {

    @Autowired
    public DataSourceService dataSourceService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer processAddDataSourceForm(@RequestBody(required = false) DataSource dataSource){
        return dataSourceService.insertDataSource(dataSource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DataSource> displayAllDataSources(){
        return dataSourceService.findAllDataSources();
    }

}
