package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository)
    {
        return args -> {
           Student ahmed = new Student(
              "Ahmed",
                    "AhmedEmad@email.com",
                    LocalDate.of(2001, Month.JUNE,1),
                    24
            );
            Student tarek = new Student(
                    "Tarek",
                    "TarekEmad@email.com",
                    LocalDate.of(1997, Month.DECEMBER,18),
                    28
            );
            repository.saveAll(
                    List.of(ahmed,tarek)
            );
        };
    }
}
