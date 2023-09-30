package com.fintrack.app.controller;

import com.fintrack.app.dto.TransactionDTO;
import com.fintrack.app.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @GetMapping
    TransactionDTO registerTransaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.registerTransaction(transactionDTO);
    }
}
