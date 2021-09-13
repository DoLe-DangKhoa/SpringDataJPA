package com.example.demospringdatajpa;

import com.example.demospringdatajpa.entity.Student;
import com.example.demospringdatajpa.reponsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringDataJpaApplication {
    @Autowired
    private StudentReponsitory studentReponsitory;
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentReponsitory e) {
        return (args) -> {
//            add(new Student("Do","Khoa", "khoado@email.com"));
            delete((long) 1);
            update((long) 2,"Doan");
            System.out.println(e.findAll());
        };
    }
    private Student add(Student student) {
        return studentReponsitory.save(student);
    }
    private void delete(Long id) {

        studentReponsitory.deleteById(id);
        System.out.println(id);
    }
    private void update(long id,String email){

        studentReponsitory.update(id,email);
        System.out.println("update complete employee: "+ studentReponsitory.findById(id));
    }


}
