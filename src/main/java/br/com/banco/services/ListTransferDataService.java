package br.com.banco.services;

import br.com.banco.dtos.EntityConverterDTO;
import br.com.banco.dtos.TransferDTO;
import br.com.banco.entities.TransferEntity;
import br.com.banco.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListTransferDataService {

    @Autowired
    TransferRepository transferRepository;

    @Transactional(readOnly = true)
    public List<TransferDTO> findByAccountId(Long accountId) {
        List<TransferEntity> transfers = transferRepository.findByAccountId(accountId);
        return transfers.stream().map(EntityConverterDTO::convertTransferToDTO).collect(Collectors.toList());
    }
}
