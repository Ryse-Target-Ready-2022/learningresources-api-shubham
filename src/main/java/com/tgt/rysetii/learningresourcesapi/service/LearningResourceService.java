package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class LearningResourceService {

    @Autowired
    private LearningResourceRepository learningResourceRepository;

    public List<LearningResource> getLearningResources(){
        return new ArrayList<>(learningResourceRepository.findAll());
    }

    public void saveLearningResources(List<LearningResource> learningResources){
        for(LearningResource learningResource: learningResources){
            learningResourceRepository.save(learningResource);
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

    //public static void main(String[] args) {}
}
