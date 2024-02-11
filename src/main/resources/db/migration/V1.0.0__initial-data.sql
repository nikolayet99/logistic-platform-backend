begin;

INSERT INTO `person` (`date_created`, `date_updated`, `address`, `email`, `name`, `person_type`, `phone_number`)
VALUES
	('2024-02-11', '2024-02-11', "Pernik", "niki@email.bg", "Nikolay", 'EMPLOYEE', 0888888888),
	('2024-02-11', '2024-02-11', "Sofia", "petran@email.bg", "Petran", 'CLIENT', 0891234567),
	('2024-02-11', '2024-02-11', "Plovdiv", "ivan@email.bg", "Ivan", 'CLIENT', 0891234567),
	('2024-02-11', '2024-02-11', "Varna", "sasho@email.bg", "Sasho", 'CLIENT', 0891123147);

INSERT INTO `user` (`date_created`, `date_updated`, `password`, `role`, `username`, `person_id`)
VALUES
	('2024-02-11', '2024-02-11', 'Niki1234', 1, 'niksan', 1),
	('2024-02-11', '2024-02-11', 'Petran1234', 0, 'petro', 2),
	('2024-02-11', '2024-02-11', 'Vane1234', 0, 'vankata', 3),
	('2024-02-11', '2024-02-11', 'Sasho123', 0, 'sasho', 4);

INSERT INTO `company` (`id`, `date_created`, `date_updated`, `name`)
VALUES
	(NULL, '2024-02-11', '2024-02-11', 'Firmata');

INSERT INTO `office` (`date_created`, `date_updated`, `address`, `email`, `name`, `phone_number`)
VALUES
	('2024-02-11', '2024-02-11', "Sofia", "of1@firma.com", "Firmata Sofia", 0871218297),
	('2024-02-11', '2024-02-11', "Plovdiv", "of2@firma.com", "Firmata Plovdiv", 0893821793);

INSERT INTO `package` (`date_created`, `date_updated`, `content`, `price`, `received`, `sent`, `employee_id`, `receiver_id`, `receiver_office_id`, `sender_id`, `sender_office_id`)
VALUES
	('2024-02-11', '2024-02-11', 'iphone', 2000, 1, 1, 1, 2, 2, 3, 1),
	('2024-02-11', '2024-02-11', 'watch', 655, 0, 1, 1, 2, 2, 3, 1),
	('2024-02-11', '2024-02-11', 'cards', 17.50, 1, 1, 1, 3, 1, 2, 2);

INSERT INTO `bill` (`date_created`, `date_updated`, `price`, `package_id`)
VALUES
	('2024-02-11', '2024-02-11', 5.25, 1),
	('2024-02-11', '2024-02-11', 5.25, 2),
	('2024-02-11', '2024-02-11', 5.25, 3);

commit;