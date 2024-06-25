package org.example.hospitalrest.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.hospitalrest.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@ApplicationScoped
public class UserService {

    private SessionFactory sessionFactory;

    public UserService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<User> getUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT u FROM User u", User.class).getResultList();
        }
    }

    public User getUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public User getByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }

    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public User updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return user;
        }
    }

    public void deleteUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user = getUser(id);
            if (user != null) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
            }
        }
    }
}