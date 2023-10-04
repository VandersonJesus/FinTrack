package com.fintrack.app.transaction.controller;

import com.fintrack.app.transaction.dto.TransactionDTO;
import com.fintrack.app.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    TransactionDTO registerTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.registerTransaction(transactionDTO);
    }

    @GetMapping("/all")
    ModelAndView transaction() {
        ModelAndView modelAndView = new ModelAndView("/transaction");
        modelAndView.addObject("transactions", transactionService.findAll());
        return modelAndView;
    }
}
