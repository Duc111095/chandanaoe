package com.ducnh.chandanaoe.database.seeder;

import com.ducnh.chandanaoe.modules.users.entities.User;
import com.ducnh.chandanaoe.modules.users.repositories.UserRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;


@Component
public class DatabaseSeeder implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isTableEmpty()) {
            String passwordEncode = passwordEncoder.encode("password");

            User user = new User();
            user.setName("Duc Nguyen");
            user.setEmail("huynhduc111095@gmail.com");
            user.setPassword(passwordEncode);
            user.setUserCatalogueId(1L);
            user.setPhone("0377776595");
            userRepository.save(user);
        }
    }

    private boolean isTableEmpty() {
        Long count = (Long) entityManager.createQuery("SELECT count(id) FROM User").getSingleResult();
        return count == 0;
    }
;}
