package br.com.banco.dtos;

import br.com.banco.entities.AccountEntity;
import br.com.banco.entities.TransferEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferDTO {
    private Long id;
    private LocalDateTime transferDate;
    private BigDecimal value;
    private String type;
    private String transactionOperatorName;
    private AccountEntity account;

    public TransferDTO(){}

    public TransferDTO(TransferEntity entity) {
        id = entity.getId();
        transferDate = entity.getTransferDate();
        value = entity.getValue();
        type = entity.getType();
        transactionOperatorName = entity.getTransactionOperatorName();
        account = entity.getAccount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionOperatorName() {
        return transactionOperatorName;
    }

    public void setTransactionOperatorName(String transactionOperatorName) {
        this.transactionOperatorName = transactionOperatorName;
    }

}
