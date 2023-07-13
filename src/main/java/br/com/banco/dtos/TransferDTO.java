package br.com.banco.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferDTO {
    private Long id;
    private LocalDateTime transferDate;
    private BigDecimal value;
    private String type;
    private String transactionOperatorName;
    private AccountDTO account;

    public TransferDTO(){}

    public TransferDTO(Long id, LocalDateTime transferDate, BigDecimal value, String type, String transactionOperatorName, AccountDTO account) {
        this.id = id;
        this.transferDate = transferDate;
        this.value = value;
        this.type = type;
        this.transactionOperatorName = transactionOperatorName;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getTransactionOperatorName() {
        return transactionOperatorName;
    }

    public AccountDTO getAccount() {
        return account;
    }
}
