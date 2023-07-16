package br.com.banco.controllers;

import br.com.banco.dtos.TransferDTO;
import br.com.banco.services.ListTransferDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/transfers")
public class ListTransferDataController {

    @Autowired
    ListTransferDataService listTransferDataService;

    @GetMapping("/{accountId}")
    public List<TransferDTO> findByAccountId(@PathVariable("accountId") Long accountId,
                                             @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                             @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                             @RequestParam(value = "transactionOperatorName", required = false) String transactionOperatorName,
                                             @RequestParam(value = "type", required = false) String type
                                             ) {

        return listTransferDataService.findByAccountId(accountId, startDate, endDate, transactionOperatorName, type);

    }
}
