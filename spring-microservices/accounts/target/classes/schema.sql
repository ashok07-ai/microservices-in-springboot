CREATE TABLE IF NOT EXISTS `customers`(
`customer_id` int AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`mobile_number` VARCHAR(20) NOT NULL,
`created_at` date NOT NULL,
`created_by` VARCHAR(20) NOT NULL,
`updated_at` date NOT NULL,
`updated_by` VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `accounts` (
    `account_id` INT AUTO_INCREMENT PRIMARY KEY,
    `customer_id` INT NOT NULL,
    `account_number` BIGINT NOT NULL UNIQUE,
    `account_type` VARCHAR(100) NOT NULL,
    `branch_address` VARCHAR(200) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` date NOT NULL,
    `updated_by` VARCHAR(20),
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
);
