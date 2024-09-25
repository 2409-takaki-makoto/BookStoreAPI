CREATE DATABASE IF NOT EXISTS book_store^;

use book_store^;


CREATE TABLE IF NOT EXISTS users (
	id CHAR(36) NOT NULL PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	email_address VARCHAR(256) NOT NULL UNIQUE,
	password VARCHAR(256) NOT NULL,
	created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP 
)^;

CREATE TABLE IF NOT EXISTS books (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 	title VARCHAR(50) NOT NULL,
 	author VARCHAR(30) NOT NULL,
 	price INT(10) NOT NULL,
 	stock INT(10) NOT NULL,
 	sales_status_code CHAR(2) NOT NULL default '01',
 	created_date DATETIME NOT NULL default CURRENT_TIMESTAMP,
 	updated_date DATETIME NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
)^;

CREATE TABLE IF NOT EXISTS orders (
	id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id CHAR(36) NOT NULL,
	book_id INT(11) NOT NULL,
	order_qty INT(10) NOT NULL,
	unit_cost INT(10) NOT NULL,
	tax_rate FLOAT NOT NULL,
	total_cost INT(11) NOT NULL,
	tax INT(10) NOT NULL,
	order_date DATETIME NOT NULL default CURRENT_TIMESTAMP,
	order_status_code CHAR(2) NOT NULL default '01',
	created_date DATETIME NOT NULL default CURRENT_TIMESTAMP,
	updated_date DATETIME NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
	FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
	FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
)^;




DROP PROCEDURE IF EXISTS insert_user^;

CREATE PROCEDURE insert_user (
	IN p_id CHAR(36),
    IN p_name VARCHAR(20),
    IN p_email_address VARCHAR(256)
)
BEGIN
	INSERT INTO users (
		id,
		name,
		email_address,
		password
	) VALUES (
		p_id,
		p_name,
		p_email_address,
		'password'
	)
	ON DUPLICATE KEY UPDATE id = id;
--    DECLARE user_count INT;
--
--
--    SELECT COUNT(*) INTO user_count FROM users;
--    
--    WHILE user_count < 1000 DO
--    	INSERT INTO users (
--			id,
--			name,
--			email_address,
--			password
--		) VALUES (
--			UUID(),
--			CONCAT('ダミー ユーザー', user_count + 1),
--			CONCAT('example', user_count + 1, '@email.com'),
--			'password'
--		);
--		
--		SET user_count = user_count + 1;
--	END WHILE;
	
END ^;

--CALL insert_user('ダミー ユーザー', 'example@email.com', 'password')^;
--CALL insert_user()^;


