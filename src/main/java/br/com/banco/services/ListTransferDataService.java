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
    public List<TransferDTO> findByAccountId(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
        List<TransferEntity> transfers = transferRepository.findByAccountId(accountId);
        List<TransferDTO> transferDTOs = transfers.stream()
                .map(EntityConverterDTO::convertTransferToDTO)
                .collect(Collectors.toList());

        BigDecimal totalBalance = transferDTOs.stream()
                .map(TransferDTO::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balanceInPeriod = transferDTOs.stream()
                .filter(transferDTO -> transferDTO.getTransferDate().isAfter(startDate) && transferDTO.getTransferDate().isBefore(endDate))
                .map(TransferDTO::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        transferDTOs.forEach(transferDTO -> {
            transferDTO.setTotalBalance(totalBalance);
            transferDTO.setBalanceInPeriod(balanceInPeriod);
        });


        return transferDTOs.stream()
                .filter(transferDTO -> transferDTO.getTransferDate().isAfter(startDate) && transferDTO.getTransferDate().isBefore(endDate))
//                .filter(transferDTO -> transferDTO.getTransactionOperatorName().)
                .collect(Collectors.toList());
    }
}


