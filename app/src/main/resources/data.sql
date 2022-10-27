INSERT INTO person (name, last_name, birth_date, year_income, passport)
VALUES ('Vasiliy', 'Ivanov', '1990.12.31', '2020.0', 'HB1111111');

INSERT INTO person (name, last_name, birth_date, year_income, passport)
VALUES ('Sergei', 'Black', '1991.03.08', '2520.0', 'HB3333333');

INSERT INTO person (name, last_name, birth_date, year_income, passport)
VALUES ('Peter', 'Petrov', '1970.05.01', '2520.0', 'HB7777777');

INSERT INTO loan (name, purpose, interest_rate, max_sum, term_in_months)
VALUES ('Consumer loan', 'CONSUMER', '9.0', '2000.0', '12');

INSERT INTO loan (name, purpose, interest_rate, max_sum, term_in_months)
VALUES ('Loan for car', 'CAR_LOAN', '12.0', '5000.0', '24');

INSERT INTO loan (name, purpose, interest_rate, max_sum, term_in_months)
VALUES ('Mortgage', 'MORTGAGE', '14.0', '10000.0', '48');

INSERT INTO extradition (person_id, loan_id, issue_date)
VALUES ('1', '1', '2022.10.01');

INSERT INTO extradition (person_id, loan_id, issue_date)
VALUES ('2', '2', '2022.10.01');

INSERT INTO extradition (person_id, loan_id, issue_date)
VALUES ('3', '3', '2022.10.01');