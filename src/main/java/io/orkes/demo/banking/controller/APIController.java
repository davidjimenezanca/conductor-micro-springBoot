package io.orkes.demo.banking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.orkes.demo.banking.pojos.DepositDetail;
import io.orkes.demo.banking.service.FraudCheckService;
import io.orkes.demo.banking.workers.FraudCheckResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class APIController {

    private final FraudCheckService fraudCheckService;

    @PostMapping(value = "/deposit", produces = "application/json")
    public ResponseEntity<FraudCheckResult> triggerDeposit(@RequestBody DepositDetail depositDetail) {
        log.info("Checking for fraud: {}", depositDetail);
        return ResponseEntity.ok(fraudCheckService.checkForFraud(depositDetail));
    }
    // docs-marker-end-1

}
