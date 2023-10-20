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
        Transaction transactionSaved = transactionRepository.findById(id).orElse(null);

        if (transactionSaved!=null){
            transactionSaved.setReference(transaction.getReference());
            transactionSaved.setAccountIban(transaction.getAccountIban());
            transactionSaved.setDate(transaction.getDate());
            transactionSaved.setAmount(transaction.getAmount());
            transactionSaved.setFee(transaction.getFee());
            transactionSaved.setDescription(transaction.getDescription());
            transactionSaved.setStatus(transaction.getStatus());
            transactionSaved.setChannel(transaction.getChannel());
            transactionSaved.save();
        }





        return null;
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return null;
    }

    @Override
    public List<Transaction> findTransactionsByIban(String iban) {
        return transactionRepository.findAllByAccountIban(iban);
    }
}
