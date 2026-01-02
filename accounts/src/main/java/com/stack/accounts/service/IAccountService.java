package com.stack.accounts.service;

import com.stack.accounts.dto.CustomerDTO;

public interface IAccountService {
    /**
     *
     * @param customerDTO - CustomerDTO object
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Account Details based on the given mobile number
     */

    CustomerDTO getAccount(String mobileNumber);

    /**
     *
     * @param customerDTO - CustomerDto Object
     * @return boolean indicating if the update Account details is successful or not
     */

    boolean updateAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if the delete of Account is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
