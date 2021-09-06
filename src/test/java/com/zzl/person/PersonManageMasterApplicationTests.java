package com.zzl.person;

import com.zzl.person.bean.MEmployee;
import com.zzl.person.service.BasicInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonManageMasterApplicationTests {

    @Autowired
    BasicInformationService basicInformationService;

    @Test
    void contextLoads() {
        MEmployee employee = basicInformationService.getMEmployeeByEmpNo("1");

        System.out.println(employee.toString());
    }

}
