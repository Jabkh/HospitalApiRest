package org.example.hospitalrest.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.hospitalrest.model.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@ApplicationScoped
public class PatientService {

    private SessionFactory sessionFactory;

    public PatientService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Patient> getPatients() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
        }
    }

    public Patient getPatient(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Patient.class, id);
        }
    }

    public void addPatient(Patient patient) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        }
    }

    public Patient updatePatient(Patient patient) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(patient);
            session.getTransaction().commit();
            return patient;
        }
    }

    public void deletePatient(int id) {
        try (Session session = sessionFactory.openSession()) {
            Patient patient = getPatient(id);
            if (patient != null) {
                session.beginTransaction();
                session.delete(patient);
                session.getTransaction().commit();
            }
        }
    }
}