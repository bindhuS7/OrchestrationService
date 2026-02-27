package com.bindhu.OrchestratorService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequest {

    private String productCode;
    private int quantity;
    private double amount;
}