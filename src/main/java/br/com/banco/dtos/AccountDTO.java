package br.com.banco.dtos;

public class AccountDTO {
    private Long idAccount;
    private String responsibleName;

    public AccountDTO(){}

    public AccountDTO(Long idAccount, String responsibleName) {
        this.idAccount = idAccount;
        this.responsibleName = responsibleName;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public String getResponsibleName() {
        return responsibleName;
    }
}
