package org.example.hospitalrest.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Prescription extends Treatment {

    private String drugName;
}