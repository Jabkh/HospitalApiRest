package org.example.hospitalrest.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @ManyToMany(mappedBy = "treatments")
    private List<Consultation> consultations;

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

}