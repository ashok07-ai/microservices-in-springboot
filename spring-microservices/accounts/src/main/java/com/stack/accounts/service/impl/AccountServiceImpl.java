package com.stack.accounts.service.impl;

import com.stack.accounts.constant.AccountConstant;
import com.stack.accounts.dto.AccountDTO;
import com.stack.accounts.dto.CustomerDTO;
import com.stack.accounts.entity.Account;
import com.stack.accounts.entity.Customer;
import com.stack.accounts.exception.CustomerAlreadyExistsException;
import com.stack.accounts.exception.ResourceNotFoundException;
import com.stack.accounts.mapper.AccountMapper;
import com.stack.accounts.mapper.CustomerMapper;
import com.stack.accounts.repository.AccountRepository;
import com.stack.accounts.repository.CustomerRepository;
import com.stack.accounts.service.IAccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository){
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * @param customerDTO - CustomerDTO object
     */
    @Override
    @Transactional
    public void createAccount(CustomerDTO customerDTO){
        Customer customer = CustomerMapper.mapToCustomerEntity(customerDTO, new Customer());
        Optional<Customer> existingCustomer =
                customerRepository.findByMobileNumber(customerDTO.getMobileNumber());

        if(existingCustomer.isPresent()){
            throw new CustomerAlreadyExistsException(
                    "Customer already registered with mobile " + customerDTO.getMobileNumber()
            );
        }

        Customer savedCustomer = customerRepository.save(customer);

        Account account =  createNewAccount(savedCustomer);
        accountRepository.save(account);
    }

    /**
     *
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer){
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountConstant.SAVINGS);
        newAccount.setBranchAddress(AccountConstant.ADDRESS);
        return newAccount;
    }

    @Override
    public CustomerDTO getAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString())
        );

        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDTO.setAccountDTO(AccountMapper.mapToAccountDTO(account, new AccountDTO()));
        return customerDTO;
    }

    @Override
    @Transactional
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountDTO accountDTO = customerDTO.getAccountDTO();
        if(accountDTO != null){
            Account account = accountRepository.findById(accountDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountDTO.getAccountNumber().toString())
            );

            AccountMapper.mapToAccountEntity(accountDTO, account);
            account = accountRepository.save(account);

            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString())
            );

            CustomerMapper.mapToCustomerEntity(customerDTO, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
