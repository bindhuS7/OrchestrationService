package com.bindhu.OrchestratorService.service;

import com.bindhu.OrchestratorService.client.InventoryClient;
import com.bindhu.OrchestratorService.client.PaymentClient;
import com.bindhu.OrchestratorService.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SagaService {

    private final PaymentClient paymentClient;
    private final InventoryClient inventoryClient;

    public Boolean processSaga(OrderRequest request) {

        // Step 1: Payment
        boolean paymentSuccess = paymentClient.pay(request);

        if (!paymentSuccess) {
            return false;
        }

        // Step 2: Inventory
        boolean stockSuccess = inventoryClient.reduceStock(request);

        if (!stockSuccess) {
log.info("request :"+request.getAmount()+" qty:"+request.getQuantity());
            // Compensation: Refund Payment
            paymentClient.refund(request);

            return false;
        }

        return true;
    }
}