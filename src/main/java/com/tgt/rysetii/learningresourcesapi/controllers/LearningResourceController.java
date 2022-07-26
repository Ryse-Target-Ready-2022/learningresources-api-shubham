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

    private final LearningResourceService service;

    public LearningResourceController(LearningResourceService learningResourceService) {
        this.service = learningResourceService;
    }

    @GetMapping("/")
    public List<LearningResource> handleGetAll(){
        return service.getLearningResources();
    }

    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody List<LearningResource> learningResources){
        service.saveLearningResources(learningResources);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteLearningResources(@PathVariable int id){
        service.deleteLearningResourceById(id);
    }

}
