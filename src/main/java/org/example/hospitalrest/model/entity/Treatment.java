package org.example.hospitalrest.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date startDate;
    private LocalDate endDate;

    @ManyToMany
    private List<Consultation> consultations;

    // Getters et setters pour startDate et endDate
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
