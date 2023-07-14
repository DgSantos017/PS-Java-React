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

    public Long getIdAccount() {
        return idAccount;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

}
