package com.tgt.rysetii.learningresourcesapi.controllers;


import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/learningresources")
public class LearningResourceController {

    @Autowired
    LearningResourceService service;

    @GetMapping("/")
    public List<LearningResource> handleGetAll(){
        return service.getLearningResources();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody LearningResource learningResources){
        List<LearningResource> list = new ArrayList<>();
        list.add(learningResources);
        service.saveLearningResources(list);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteLearningResources(@PathVariable int id){
        service.deleteLearningResourceById(id);
    }

}
