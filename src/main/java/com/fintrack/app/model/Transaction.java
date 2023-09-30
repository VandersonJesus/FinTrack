package com.fintrack.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fintrack.app.dto.TransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "customer_id",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long transactionId;
    private String description;
    private Double value;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    public static Transaction dtoToEntity(final TransactionDTO dto){
        return Transaction.builder()
                .transactionId(dto.transactionId())
                .description(dto.description())
                .value(dto.value())
                .date(dto.date())
                .build();
    }
}
