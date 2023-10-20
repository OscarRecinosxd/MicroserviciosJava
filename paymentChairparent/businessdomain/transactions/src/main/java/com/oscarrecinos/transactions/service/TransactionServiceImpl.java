package com.oscarrecinos.transactions.service;

import com.oscarrecinos.transactions.entity.Transaction;
import com.oscarrecinos.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionlService{
    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, Long id) {
        transaction.setId(id);
        transactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public Transaction findByIdTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> findTransactionsByIban(String iban) {
        return transactionRepository.findAllByAccountIban(iban);
    }
}
