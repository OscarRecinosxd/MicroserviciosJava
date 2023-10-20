package com.oscarrecinos.transactions.controller;

import com.oscarrecinos.transactions.entity.Transaction;
import com.oscarrecinos.transactions.service.TransactionlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionlService transactionlService;

    @GetMapping()
    public List<Transaction> findAll() {
        return transactionlService.findAllTransaction();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionlService.findByIdTransaction(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        Transaction save = transactionlService.updateTransaction(transaction,id);
        return ResponseEntity.ok(save);
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        Transaction save = transactionlService.createTransaction(transaction);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/customer/transactions")
    public ResponseEntity<?> findByIban(@RequestParam String iban) {
        List<Transaction> transaction = transactionlService.findTransactionsByIban(iban);
        return ResponseEntity.ok(transaction);
    }

}
