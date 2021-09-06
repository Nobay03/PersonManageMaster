package com.zzl.person;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.zzl.person.mapper")
@ServletComponentScan(basePackages = "com.zzl.person")
@SpringBootApplication
public class PersonManageMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonManageMasterApplication.class, args);
    }

}
