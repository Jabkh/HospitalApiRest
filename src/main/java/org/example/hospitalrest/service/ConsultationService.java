package org.example.hospitalrest.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.hospitalrest.model.entity.Consultation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@ApplicationScoped
public class ConsultationService {

    private SessionFactory sessionFactory;

    public ConsultationService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Consultation> getConsultations() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c FROM Consultation c", Consultation.class).getResultList();
        }
    }

    public Consultation getConsultation(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Consultation.class, id);
        }
    }

    public void addConsultation(Consultation consultation) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(consultation);
            session.getTransaction().commit();
        }
    }

    public Consultation updateConsultation(Consultation consultation) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(consultation);
            session.getTransaction().commit();
            return consultation;
        }
    }

    public void deleteConsultation(int id) {
        try (Session session = sessionFactory.openSession()) {
            Consultation consultation = getConsultation(id);
            if (consultation != null) {
                session.beginTransaction();
                session.delete(consultation);
                session.getTransaction().commit();
            }
        }
    }
}