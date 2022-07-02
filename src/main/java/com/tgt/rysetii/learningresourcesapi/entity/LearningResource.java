package com.tgt.rysetii.learningresourcesapi.entity;

import java.time.LocalDate;


public class LearningResource {
    private Integer id;
    private String name;
    private Double costPrice;
    private Double sellingPrice;
    private LearningResourceStatus productStatus;
    private LocalDate createdDate;
    private LocalDate publishedDate;
    private LocalDate retiredDate;

    public LearningResource() {
    }

    public LearningResource(Integer learningResourceId, String productName, Double costPrice, Double sellingPrice, LearningResourceStatus learningResourceStatus, LocalDate createdDate, LocalDate publishedDate, LocalDate retiredDate) {
        this.id = learningResourceId;
        this.name = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productStatus = learningResourceStatus;
        this.createdDate = createdDate;
        this.publishedDate = publishedDate;
        this.retiredDate = retiredDate;
    }

    public Integer getLearningResourceId() {
        return id;
    }

    public void setLearningResourceId(Integer learningResourceId) {
        this.id = learningResourceId;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String productName) {
        this.name = productName;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LearningResourceStatus getLearningResourceStatus() {
        return productStatus;
    }

    public void setLearningResourceStatus(LearningResourceStatus learningResourceStatus) {
        this.productStatus = learningResourceStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(LocalDate retiredDate) {
        this.retiredDate = retiredDate;
    }
}
