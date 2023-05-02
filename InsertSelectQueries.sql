create database BankSystem;
use BankSystem;
select * from account;
select * from customer;
select * from loan;
select * from credit_card;
select * from bank_account_transaction;

insert into customer(created_date,is_active,updated_date,email,first_name,last_name,phone_number) values 
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333','S@hotmail.com','Salim','Mohammed',99443321),
('2022-02-20 11:59:42.6533333',1,'2023-03-05 12:37:54.7820000','R@hotmail.com','Rawdha','Said',99443322),
('2022-02-23 11:59:42.6533344',1,'2023-01-01 14:59:37.0500000','M@hotmail.com','Mohammed','Naser',99445322),
('2023-03-05 09:51:05.6950000',1,'2023-03-05 14:08:55.9590000','D@hotmail.com','Daniyal','Mohammed',99443622);

insert into account(created_date,is_active,updated_date,account_balance,account_interest,account_number,account_type,customer_id) values
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333',1000,100,9909,'Saving',1),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333',1500,200,9989,'Master',2),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333',2000,250,9979,'Business',1),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333',3000,150,9969,'Saving',1);

insert into loan(created_date,is_active,updated_date,interest_rate,principal_amount,term_months,customer_id) values 
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333',50,150,90,1),
('2022-02-20 11:59:42.6533333',1,'2023-03-05 12:37:54.7820000',60,150,50,2),
('2022-02-23 11:59:42.6533344',1,'2023-01-01 14:59:37.0500000',20,150,70,3),
('2023-03-05 09:51:05.6950000',1,'2023-03-05 14:08:55.9590000',10,150,80,4);

insert into credit_card(created_date,is_active,updated_date,card_holder_name,card_number,card_type,expiry_date,security_code,account_id) values
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333','Salim Mohammed',996677301,'Credit Card', '2025-05-01', 879,1),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333','Rawdha Said',994477301,'Debit Card', '2025-06-01', 870,2),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333','Mohammed Naser',992277301,'Debit Card', '2025-05-01', 579,3),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333','Daniyal Mohammed',996977301,'Credit Card', '2025-06-01', 839,4);

insert into bank_account_transaction(created_date,is_active,updated_date,amount,date_time,description,credit_card_id) values
('2023-02-05 12:44:38.0720000',1,'2023-03-04 11:06:29.7633333',50,'2023-03-04 11:06:29.7633333','Transfer',1),
('2023-02-07 12:44:38.0720000',1,'2023-03-06 11:06:29.7633333',40,'2023-03-04 11:06:29.7633333','WithDraw',2),
('2023-03-09 12:44:38.0720000',1,'2023-01-04 11:06:29.7633333',50,'2023-03-04 11:06:29.7633333','Transfer',3),
('2023-03-05 12:44:38.0720000',1,'2023-04-04 11:06:29.7633333',20,'2023-03-04 11:06:29.7633333','WithDraw',4);