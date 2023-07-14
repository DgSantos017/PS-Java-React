package br.com.banco.services;

import br.com.banco.dtos.EntityConverterDTO;
import br.com.banco.dtos.TransferDTO;
import br.com.banco.entities.TransferEntity;
import br.com.banco.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListTransferDataService {

    @Autowired
    TransferRepository transferRepository;

    @Transactional(readOnly = true)
    public List<TransferDTO> findByAccountId(Long accountId, LocalDateTime startDate, LocalDateTime endDate, String transactionOperatorName, String type) {
        List<TransferEntity> transfers = transferRepository.findByAccountId(accountId);
        List<TransferDTO> transferDTOs = transfers.stream()
                .map(EntityConverterDTO::convertTransferToDTO)
                .collect(Collectors.toList());

        BigDecimal totalBalance = transferDTOs.stream()
                .map(TransferDTO::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceInPeriod = transferDTOs.stream()
                .filter(transferDTO -> isWithinPeriod(transferDTO.getTransferDate(), startDate, endDate))
                .map(TransferDTO::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        transferDTOs.forEach(transferDTO -> {
            transferDTO.setTotalBalance(totalBalance);
            transferDTO.setBalanceInPeriod(balanceInPeriod);
        });

        if (startDate != null && endDate != null && transactionOperatorName != null && type != null) {
            return transferDTOs.stream()
                    .filter(transferDTO -> isWithinPeriod(transferDTO.getTransferDate(), startDate, endDate))
                    .filter(transferDTO -> transferDTO.getTransactionOperatorName() != null && transferDTO.getTransactionOperatorName().toUpperCase().equals(transactionOperatorName.toUpperCase()))
                    .collect(Collectors.toList());
        }

        if (startDate == null && endDate == null && transactionOperatorName == null && type == null) {
            return transferDTOs;
        }

        return transferDTOs.stream()
                .filter(transferDTO -> startDate == null || isAfterOrEqual(transferDTO.getTransferDate(), startDate))
                .filter(transferDTO -> endDate == null || isBeforeOrEqual(transferDTO.getTransferDate(), endDate))
                .filter(transferDTO -> transactionOperatorName == null || transferDTO.getTransactionOperatorName() != null && transferDTO.getTransactionOperatorName().toUpperCase().equals(transactionOperatorName.toUpperCase()))
                .filter(transferDTO -> type == null || transferDTO.getType() != null && transferDTO.getType().toUpperCase().equals(type.toUpperCase()))
                .collect(Collectors.toList());
    }

    private boolean isWithinPeriod(LocalDateTime date, LocalDateTime startDate, LocalDateTime endDate) {
        return (startDate == null || isAfterOrEqual(date, startDate)) && (endDate == null || isBeforeOrEqual(date, endDate));
    }

    private boolean isAfterOrEqual(LocalDateTime date1, LocalDateTime date2) {
        return date1 != null && (date1.isEqual(date2) || date1.isAfter(date2));
    }

    private boolean isBeforeOrEqual(LocalDateTime date1, LocalDateTime date2) {
        return date1 != null && (date1.isEqual(date2) || date1.isBefore(date2));
    }
}



