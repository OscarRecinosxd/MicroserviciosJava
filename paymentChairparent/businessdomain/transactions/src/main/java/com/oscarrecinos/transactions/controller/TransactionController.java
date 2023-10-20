package com.oscarrecinos.transactions.controller;

import com.oscarrecinos.transactions.service.TransactionlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionlService transactionlService;


}
