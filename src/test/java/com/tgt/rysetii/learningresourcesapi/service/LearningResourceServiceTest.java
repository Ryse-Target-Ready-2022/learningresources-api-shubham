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
    void saveLearningResources() {
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
    void getProfitMargin() {
    }

    @Test
    void sortLearningResourcesByProfitMargin() {
    }

    @Test
    void deleteLearningResourceById() {
    }
}