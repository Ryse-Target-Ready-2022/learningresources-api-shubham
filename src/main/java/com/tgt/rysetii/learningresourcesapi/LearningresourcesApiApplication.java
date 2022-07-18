package com.tgt.rysetii.learningresourcesapi;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class LearningresourcesApiApplication {

	@Autowired
	LearningResourceService learningResourceService;

	public static void main(String[] args) {

		SpringApplication.run(LearningresourcesApiApplication.class, args);

		System.out.println("Hello, World! <Shubham Pandiya>");
		//developed by shubh
	}

	@PostConstruct
	public void init(){
		List<LearningResource> l1 = learningResourceService.getLearningResources();

		System.out.println("Output"+ l1.toString());
		learningResourceService.saveLearningResources(l1);
	}


}