package com.bindhu.OrchestratorService.client;

import com.bindhu.OrchestratorService.dto.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentservice")
public interface PaymentClient {

    @PostMapping("/payment/pay")
    boolean pay(@RequestBody OrderRequest request);

    @PostMapping("/payment/refund")
    void refund(@RequestBody OrderRequest request);
}