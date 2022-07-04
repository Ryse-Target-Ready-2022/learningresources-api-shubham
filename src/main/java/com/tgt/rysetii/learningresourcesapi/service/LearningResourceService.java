package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LearningResourceService {
    private List<LearningResource> getLearningResources() {
        String filename = "LearningResources.csv";
        File file = new File(filename);
        List<LearningResource> learningResources = new ArrayList<>();

        try(FileReader reader = new FileReader(file);
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

    public void saveLearningResources(List<LearningResource> learningResources){
        final String csvDelimiter = ",";

        try{
            File learningResourcesFile = new File("LearningResources.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(learningResourcesFile.getName(), true));
            for(LearningResource learningResource:learningResources){
                bufferedWriter.newLine();
                StringBuilder singleLine = new StringBuilder();
                singleLine.append(learningResource.getLearningResourceId());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getProductName());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getCostPrice());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getSellingPrice());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getLearningResourceStatus());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getCreatedDate());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getPublishedDate());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getRetiredDate());
                bufferedWriter.write(singleLine.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public List<Double> getProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();

        return learningResources.stream().map(lr->(lr.getSellingPrice()-lr.getCostPrice()/lr.getSellingPrice()))
                .collect(toList());
    }
    public List<LearningResource> sortLearningResourcesByProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();

        learningResources.sort((lr1, lr2) -> {
            Double profitMargin1 = (lr1.getSellingPrice() - lr1.getCostPrice())/lr1.getSellingPrice();
            Double profitMargin2 = (lr2.getSellingPrice() - lr2.getCostPrice())/lr2.getSellingPrice();

            return profitMargin2.compareTo(profitMargin1) ;
        });

        return learningResources;
    }
}