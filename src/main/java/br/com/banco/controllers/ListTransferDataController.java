package br.com.banco.controllers;

import br.com.banco.entities.AccountEntity;
import br.com.banco.services.ListTransferDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transfers")
public class ListTransferDataController {

    @Autowired
    ListTransferDataService listTransferDataService;

    @GetMapping
    public List<AccountEntity> findAll() {
        return listTransferDataService.findAll();
    }
}
