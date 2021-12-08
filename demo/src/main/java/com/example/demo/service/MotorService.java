package com.example.demo.service;

import com.example.demo.service.contracts.IMotorService;
import com.example.demo.service.contracts.dto.DtoInputDataTransfer;
import org.springframework.stereotype.Service;

@Service
public class MotorService implements IMotorService {


    @Override
    public String processDataConciliation(DtoInputDataTransfer dtoInputDataTransfer) {
        return "Transferencia Recebida " + dtoInputDataTransfer.getId();
    }
}
