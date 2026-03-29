package com.gaurav.firstproject;

import com.gaurav.firstproject.model.Alien;
import com.gaurav.firstproject.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(FirstProjectApplication.class, args);
        Alien alien1 = context.getBean(Alien.class);
        alien1.setId(111);
        alien1.setName("Garuav");
        alien1.setTech("Java Spring boot");
        AlienRepo repo= context.getBean(AlienRepo.class);
        repo.save(alien1);
        System.out.println(repo.findAll());


    }

}
