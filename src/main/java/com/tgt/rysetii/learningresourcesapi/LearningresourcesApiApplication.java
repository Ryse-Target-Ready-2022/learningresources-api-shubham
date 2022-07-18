package com.tgt.rysetii.learningresourcesapi;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LearningresourcesApiApplication {

	public static void main(String[] args) {

        SpringApplication.run(LearningresourcesApiApplication.class, args);
		LearningResourceService lrs = new LearningResourceService();
		List<LearningResource> l1 = lrs.getLearningResources();
		System.out.println("Output"+ l1.toString());
		lrs.saveLearningResources(l1);
		System.out.println("Hello, World! <Shubham Pandiya>");
		//developed by shubh
	}

}
