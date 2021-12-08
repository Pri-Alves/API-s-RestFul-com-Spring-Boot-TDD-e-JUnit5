package com.example.demo.service.contracts.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DtoInputDataTransfer {

    @Id
    private String id;

    private String idEmpresa;

    private String idConta;

    private String idPagador;

    private String dataTransferencia;

    private Double valor;

    public DtoInputDataTransfer(String id, String idEmpresa, String idConta, String idPagador, String dataTransferencia, Double valor) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idConta = idConta;
        this.idPagador = idPagador;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public String getIdPagador() {
        return idPagador;
    }

    public void setIdPagador(String idPagador) {
        this.idPagador = idPagador;
    }

    public String getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(String dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
