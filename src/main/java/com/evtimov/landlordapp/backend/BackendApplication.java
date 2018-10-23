package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.*;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(ChatSession.class)
                .addAnnotatedClass(Card.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Place.class)
                .addAnnotatedClass(Rent.class)
                .addAnnotatedClass(Message.class)
                .addAnnotatedClass(Rating.class)
                .buildSessionFactory();
    }
}
