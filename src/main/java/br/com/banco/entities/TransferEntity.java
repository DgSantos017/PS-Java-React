package br.com.banco.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transferencia")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_transferencia", nullable = false)
    private LocalDateTime transferDate;

    @Column(name = "valor", nullable = false)
    private BigDecimal value;

    @Column(name = "tipo", nullable = false)
    private String type;

    @Column(name = "nome_operador_transacao")
    private String transactionOperatorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id", nullable = false)
    private AccountEntity account;

    public TransferEntity() {
    }

    public TransferEntity(Long id, LocalDateTime transferDate, BigDecimal value, String type, String transactionOperatorName, AccountEntity account) {
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

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferEntity that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
