package com.sample.ecomm.service;

import com.sample.ecomm.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    public String getclients() {
        return "Success";
    }

    public String postclients(Employee bankModel) {
        //return bankModel.toString();
        updateEmployeeName("123", "Test");

        return "Test";
    }

    public String deleteclients() {
        return "deleteclients";
    }

    public void updateEmployeeName(String employeeId, String newName) {

    }

}
