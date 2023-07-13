package br.com.banco.repositories;

import br.com.banco.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
    @Query("SELECT t FROM TransferEntity t WHERE t.account.idAccount = :accountId")
    List<TransferEntity> findByAccountId(@Param("accountId") Long accountId);
}
