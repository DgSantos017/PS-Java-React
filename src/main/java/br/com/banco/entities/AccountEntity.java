package br.com.banco.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "conta")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long idAccount;

    @Column(name = "nome_responsavel", nullable = false)
    private String responsibleName;

    public AccountEntity(){}

    public AccountEntity(Long idAccount, String responsibleName) {
        this.idAccount = idAccount;
        this.responsibleName = responsibleName;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountEntity)) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(getIdAccount(), that.getIdAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAccount());
    }
}
