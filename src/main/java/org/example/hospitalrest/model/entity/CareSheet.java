package org.example.hospitalrest.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class CareSheet extends Treatment {
    private String careType;

    @ManyToMany(mappedBy = "careSheets")
    private List<Consultation> consultations;

    public String getCareType() {
        return careType;
    }

    public void setCareType(String careType) {
        this.careType = careType;
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
