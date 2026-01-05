package com.stack.accounts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountDTO {
    @JsonIgnore
    @NotEmpty(message = "Account number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Account number of seven stack account"
    )
    private Long accountNumber;


    @NotEmpty(message = "Account type cannot be null or empty")
    @Schema(
            description = "Account type of seven stack account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "Branch address cannot be a null or empty")
    @Schema(
            description = "Seven stack branch address", example = "123 NewYork"
    )
    private String branchAddress;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
