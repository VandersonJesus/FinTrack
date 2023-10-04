package com.fintrack.app.transaction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fintrack.app.transaction.model.Transaction;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TransactionDTO(
        Long transactionId,
        String description,
        Double value,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate date) {
    public static TransactionDTO entityToDto(final Transaction transaction){
        return TransactionDTO.builder()
                .transactionId(transaction.getTransactionId())
                .description(transaction.getDescription())
                .value(transaction.getValue())
                .date(transaction.getDate())
                .build();
    }
}
