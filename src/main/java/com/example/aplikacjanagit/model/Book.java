package com.example.aplikacjanagit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private LocalDate productionYear;
    public Book(Long id, String title, LocalDate productionYear) {
        this.id = id;
        this.title = title;
        this.productionYear = productionYear;
    }
    public Book() {}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public LocalDate getProductionYear() {return productionYear;}
    public void setProductionYear(LocalDate productionYear) {this.productionYear = productionYear;}
    public void setId(Long id) {this.id = id;}
    @Id
    public Long getId() {return id;}
}
