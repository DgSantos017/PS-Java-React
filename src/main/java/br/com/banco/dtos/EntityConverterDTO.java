package br.com.banco.dtos;

import br.com.banco.entities.AccountEntity;
import br.com.banco.entities.TransferEntity;

public class EntityConverterDTO {
    public static TransferDTO convertTransferToDTO(TransferEntity transferEntity) {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setId(transferEntity.getId());
        transferDTO.setTransferDate(transferEntity.getTransferDate());
        transferDTO.setValue(transferEntity.getValue());
        transferDTO.setType(transferEntity.getType());
        transferDTO.setTransactionOperatorName(transferEntity.getTransactionOperatorName());

        AccountEntity accountEntity = transferEntity.getAccount();
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setIdAccount(accountEntity.getIdAccount());
        accountDTO.setResponsibleName(accountEntity.getResponsibleName());

        return transferDTO;
    }
}

