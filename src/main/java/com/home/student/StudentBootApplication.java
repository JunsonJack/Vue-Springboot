package com.home.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.home.student.mapper")
public class StudentBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentBootApplication.class, args);
    }

}
