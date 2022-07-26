package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LearningResourceServiceTest {

    @Mock
    LearningResourceRepository repository;

    private LearningResourceService service;

    @BeforeEach
    public void setup(){
        service = new LearningResourceService(repository);
    }

    @Test
    public void saveLearningResources() {
        List<LearningResource> list = new ArrayList<>();
        LearningResource ls1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource ls2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        LearningResource ls3 = new LearningResource(1313, "Test Name 3", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        list.add(ls1);
        list.add(ls2);
        list.add(ls3);

        service.saveLearningResources(list);
        verify(repository, times(list.size())).save(any(LearningResource.class));
    }

    @Test
    public void getProfitMargin() {
        List<LearningResource> learningResourcesList = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResourcesList.add(learningResource1);
        learningResourcesList.add(learningResource2);

        List<Double> expectedProfitMargins = learningResourcesList.stream()
                .map(lr->(lr.getSellingPrice()-lr.getCostPrice()/lr.getSellingPrice()))
                .collect(toList());

        when(repository.findAll()).thenReturn(learningResourcesList);

        List<Double> actualProfitMargins = service.getProfitMargin();
        assertEquals(expectedProfitMargins,actualProfitMargins, "Wrong profit margins");
    }

    @Test
    public void sortLearningResourcesByProfitMargin() {
        List<LearningResource> sortedList = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        sortedList.add(learningResource1);
        sortedList.add(learningResource2);

        sortedList.sort((lr1, lr2) -> {
            Double profitMargin1 = (lr1.getSellingPrice() - lr1.getCostPrice())/lr1.getSellingPrice();
            Double profitMargin2 = (lr2.getSellingPrice() - lr2.getCostPrice())/lr2.getSellingPrice();

            return profitMargin2.compareTo(profitMargin1) ;
        });

        when(repository.findAll()).thenReturn(sortedList);
        List<LearningResource> actualSrotedList = service.sortLearningResourcesByProfitMargin();
        assertEquals(sortedList, actualSrotedList, "Wrongly sorted");
    }

    @Test
    public void deleteLearningResourceById() {
        int learningResourceId = 1234;
        service.deleteLearningResourceById(learningResourceId);
        verify(repository, times(1)).deleteById(learningResourceId);
    }
}