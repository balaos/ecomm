package com.sample.ecomm.controller;

import com.sample.ecomm.model.Employee;
import com.sample.ecomm.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    private BankService bankService;

    @GetMapping("/clients")
    public String getclients() {
        return bankService.getclients();
    }

    @PostMapping("/postclients")
    public String postclients(@RequestBody Employee bankModel) {
        return bankService.postclients(bankModel);
    }

    @DeleteMapping("/deleteclients")
    public String deleteclients() {
        return bankService.deleteclients();
    }
}
