package br.com.banco.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public AccountEntity getAccount() {
        return account;
    }

}
