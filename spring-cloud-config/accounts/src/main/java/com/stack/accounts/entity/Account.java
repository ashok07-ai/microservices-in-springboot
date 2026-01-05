package com.stack.accounts.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")

public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "account_number", nullable = false, unique = true)
    private Long accountNumber;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    public Account(){

    }

    public Account(Long accountNumber, Long customerId, String branchAddress, String accountType) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.branchAddress = branchAddress;
        this.accountType = accountType;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}