package com.fintrack.app.transaction.service;

import com.fintrack.app.transaction.dto.TransactionDTO;
import com.fintrack.app.transaction.model.Transaction;
import com.fintrack.app.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDTO registerTransaction(final TransactionDTO transactionDTO) {
        return TransactionDTO.entityToDto(transactionRepository.save(Transaction.dtoToEntity(transactionDTO)));
    }

    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll().stream().map(TransactionDTO::entityToDto).toList();
    }
}
