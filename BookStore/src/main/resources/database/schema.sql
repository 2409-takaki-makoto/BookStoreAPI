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




DROP PROCEDURE IF EXISTS insert_user^;

CREATE PROCEDURE insert_user (
--    IN p_name VARCHAR(20),
--    IN p_email_address VARCHAR(256),
--    IN p_password VARCHAR(256)
)
BEGIN
    DECLARE user_count INT;


    SELECT COUNT(*) INTO user_count FROM users;
    
    WHILE user_count < 1000 DO
    	INSERT INTO users (
			id,
			name,
			email_address,
			password
		) VALUES (
			UUID(),
			CONCAT('ダミー ユーザー', user_count + 1),
			CONCAT('example', user_count + 1, '@email.com'),
			'password'
		);
		
		SET user_count = user_count + 1;
	END WHILE;
	
END ^;

--CALL insert_user('ダミー ユーザー', 'example@email.com', 'password')^;
CALL insert_user()^;


