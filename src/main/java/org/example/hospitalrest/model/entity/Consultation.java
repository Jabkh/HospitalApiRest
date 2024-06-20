package org.example.hospitalrest.model.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "id_patient")
    private Patient patient;

    // Relation ManyToMany avec CareSheet
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "consultation_care_sheets",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "care_sheet_id"))
    private List<CareSheet> careSheets;

    // Relation ManyToMany avec Prescription
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "consultation_prescriptions",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id"))
    private List<Prescription> prescriptions;

    // Constructeurs, getters, setters, toString()

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTreatmentSheet() {
        return treatmentSheet;
    }

    public void setTreatmentSheet(String treatmentSheet) {
        this.treatmentSheet = treatmentSheet;
    }

    public List<CareSheet> getCareSheets() {
        return careSheets;
    }

    public void setCareSheets(List<CareSheet> careSheets) {
        this.careSheets = careSheets;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
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
