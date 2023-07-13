package br.com.banco.services;

import br.com.banco.entities.AccountEntity;
import br.com.banco.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListTransferDataService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }
}
