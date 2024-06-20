package org.example.hospitalrest.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Prescription extends Treatment {
    private String drugName;

    @ManyToMany(mappedBy = "prescriptions")
    private List<Consultation> consultations;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Override
    public List<Consultation> getConsultations() {
        return consultations;
    }

    @Override
    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
