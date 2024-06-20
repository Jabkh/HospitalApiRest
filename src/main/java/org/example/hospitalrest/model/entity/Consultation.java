package org.example.hospitalrest.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateOfConsultation;
    private String doctorName;
    private String advice;
    private String treatmentSheet;

    @ManyToOne
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Consultation() {}

    public Consultation(int id, Date dateOfConsultation, String doctorName, String advice, String treatmentSheet) {
        this.id = id;
        this.dateOfConsultation = dateOfConsultation;
        this.doctorName = doctorName;
        this.advice = advice;
        this.treatmentSheet = treatmentSheet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfConsultation() {
        return dateOfConsultation;
    }

    public void setDateOfConsultation(Date dateOfConsultation) {
        this.dateOfConsultation = dateOfConsultation;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getTreatmentSheet() {
        return treatmentSheet;
    }

    public void setTreatmentSheet(String treatmentSheet) {
        this.treatmentSheet = treatmentSheet;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateOfConsultation=" + dateOfConsultation +
                ", doctorName='" + doctorName + '\'' +
                ", advice='" + advice + '\'' +
                ", treatmentSheet='" + treatmentSheet + '\'' +
                '}';
    }
}