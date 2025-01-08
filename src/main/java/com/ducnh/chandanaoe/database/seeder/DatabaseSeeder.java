package com.ducnh.chandanaoe.database.seeder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class DatabaseSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isTableEmpty()) {
            String passwordEncode = passwordEncoder.encode("password");
            entityManager.createNativeQuery("INSERT INTO users (name, email, password, user_catalogue_id, phone) VALUES (?, ?, ?, ?, ?)")
                            .setParameter(1, "Duc Nguyen")
                            .setParameter(2, "huynhduc111095@gmail.com")
                            .setParameter(3, passwordEncode)
                            .setParameter(4, 1)
                            .setParameter(5, "0377776595")
                            .executeUpdate();
        }
    }

    private boolean isTableEmpty() {
        Long count = (Long) entityManager.createQuery("SELECT count(id) FROM User").getSingleResult();
        return count == 0;
    }
;}
