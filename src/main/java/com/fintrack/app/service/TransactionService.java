package com.fintrack.app.service;

import com.fintrack.app.dto.TransactionDTO;
import com.fintrack.app.model.Transaction;
import com.fintrack.app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    public TransactionDTO registerTransaction(final TransactionDTO transactionDTO){
        return TransactionDTO.entityToDto(transactionRepository.save(Transaction.dtoToEntity(transactionDTO)));
    }
}
