package com.dxr.hospitalmedicinemanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dxr.hospitalmedicinemanagementsystem.mapper")
public class HospitalMedicineManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalMedicineManagementSystemApplication.class, args);
    }

}
