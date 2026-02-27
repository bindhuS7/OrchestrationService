package com.bindhu.OrchestratorService.client;

import com.bindhu.OrchestratorService.dto.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventoryservice")
public interface InventoryClient {

    @PostMapping("/inventory/reduce")
    boolean reduceStock(@RequestBody OrderRequest request);
}