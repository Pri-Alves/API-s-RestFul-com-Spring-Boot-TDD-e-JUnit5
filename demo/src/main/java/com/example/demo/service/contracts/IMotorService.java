package com.example.demo.service.contracts;

import com.example.demo.service.contracts.dto.DtoInputDataTransfer;
import org.springframework.stereotype.Component;

@Component
public interface IMotorService {

    public String processDataConciliation (DtoInputDataTransfer dtoInputDataTransfer); // incluir dto contas a receber // o retorno String será substituido pela classe de conciliação

}
