package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LearningResourceService {
    private List<LearningResource> getLearningResources() {
        String filename = "LearningResources.csv";
        List<LearningResource> learningResources = new ArrayList<>();

        try(FileReader reader = new FileReader(filename);
            BufferedReader in = new BufferedReader(reader))
        {
            String line;
            line = in.readLine();
            while(line!=null){
                String[] attributes = line.split(",");
                LearningResource learningResource = createLearningResource(attributes);
                learningResources.add(learningResource);
                line = in.readLine();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return learningResources;
    }

    public LearningResource createLearningResource(String[] attributes){
        Integer id = Integer.parseInt(attributes[0].replaceAll("\\D+",""));
        String name = attributes[1];
        Double costPrice = Double.parseDouble(attributes[2]);
        Double sellingPrice = Double.parseDouble(attributes[3]);
        LearningResourceStatus learningResourceStatus = LearningResourceStatus.valueOf(attributes[4]);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate createdDate = LocalDate.parse(attributes[5], dateFormatter);
        LocalDate publishedDate = LocalDate.parse(attributes[6], dateFormatter);
        LocalDate retiredDate = LocalDate.parse(attributes[7], dateFormatter);

        return new LearningResource(
                id, name, costPrice, sellingPrice, learningResourceStatus, createdDate, publishedDate, retiredDate
        );
    }
}
