package com.stack.accounts.repository;

import com.stack.accounts.entity.Account;
import com.stack.accounts.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomerId(Long customerId);

    // Indicates that this query modifies the database state (DELETE/UPDATE)
    // rather than performing a SELECT operation
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}