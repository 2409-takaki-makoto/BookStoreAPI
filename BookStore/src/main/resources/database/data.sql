INSERT INTO users (
	id,
	name,
	email_address,
	password
) VALUES (
	'0806d989-3804-4645-a2ef-9c0d76513df2',
	'ダミー ユーザー1',
	'example@email.com',
	'password'
) ON DUPLICATE KEY UPDATE id = id^;

INSERT INTO users (
	id,
	name,
	email_address,
	password
) VALUES (
	'6f78de77-66f4-4021-a744-5fb9a5437e7b',
	'ダミー ユーザー2',
	'example2@email.com',
	'password'
) ON DUPLICATE KEY UPDATE id = id^;

INSERT INTO users (
	id,
	name,
	email_address,
	password
) VALUES (
	'946792a2-3cc0-40e7-a874-06d6c60a761c',
	'ダミー ユーザー3',
	'example3@email.com',
	'password'
) ON DUPLICATE KEY UPDATE id = id^;

INSERT INTO users (
	id,
	name,
	email_address,
	password
) VALUES (
	'cfe94e52-32b6-48af-ac96-2b92b0f989c5',
	'ダミー ユーザー4',
	'example4@email.com',
	'password'
) ON DUPLICATE KEY UPDATE id = id^;

