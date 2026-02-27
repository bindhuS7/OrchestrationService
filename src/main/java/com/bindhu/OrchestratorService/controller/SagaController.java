package com.bindhu.OrchestratorService.controller;

import com.bindhu.OrchestratorService.dto.OrderRequest;
import com.bindhu.OrchestratorService.service.SagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saga")
@RequiredArgsConstructor
public class SagaController {

    private final SagaService sagaService;

    @PostMapping("/start")
    public Boolean startSaga(@RequestBody OrderRequest request) {
        return sagaService.processSaga(request);
    }
}