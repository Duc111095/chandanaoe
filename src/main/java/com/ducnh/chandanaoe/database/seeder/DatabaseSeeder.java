package com.ducnh.chandanaoe.database.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Something seeding");
    }
}
