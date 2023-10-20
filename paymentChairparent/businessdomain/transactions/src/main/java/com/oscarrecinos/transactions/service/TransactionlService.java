package com.oscarrecinos.transactions.service;

import com.oscarrecinos.transactions.entity.Transaction;

import java.util.List;

public interface TransactionlService {
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction, Long id);
    List<Transaction> findAllTransaction();
    List<Transaction> findTransactionsByIban(String iban);
}
