INSERT INTO passport (series, number)
VALUES ('HB', '1111111'),
       ('HB', '2222222'),
       ('HB', '3333333');

INSERT INTO person (name, last_name, birth_date, year_income, passport_id)
VALUES ('Vasiliy', 'Ivanov', '1990.12.31', '2020.0', '1'),
       ('Sergei', 'Black', '1991.03.08', '2520.0', '2'),
       ('Peter', 'Petrov', '1970.05.01', '2520.0', '3');

INSERT INTO loan (name, purpose, interest_rate, max_sum, term_in_months)
VALUES ('Consumer loan', 'CONSUMER', '9.0', '2000.0', '12'),
       ('Loan for car', 'CAR_LOAN', '12.0', '5000.0', '24'),
       ('Mortgage', 'MORTGAGE', '14.0', '10000.0', '48');

INSERT INTO extradition (person_id, loan_id, issue_date)
VALUES ('1', '1', '2022.10.01'),
       ('2', '2', '2022.10.01'),
       ('3', '3', '2022.10.01');