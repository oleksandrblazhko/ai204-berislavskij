CREATE TABLE roles(
	id_role INT PRIMARY KEY,
	role_name VARCHAR CHECK(char_length(role_name) >= 5)
);

CREATE TABLE subscriptions(
	id_subscription INT PRIMARY KEY,
	subscription_name VARCHAR CHECK(char_length(subscription_name) >= 5),
	price DECIMAL(10, 2) CHECK(price >= 0)
);

CREATE TABLE users(
	id_user INT PRIMARY KEY,
	role_id INT REFERENCES roles(id_role),
	user_name VARCHAR NOT NULL,
	surname VARCHAR NOT NULL,
	balance DECIMAL(10, 2),
	email VARCHAR CHECK(email ~* '^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$'),
	mobile VARCHAR CHECK (mobile ~* '^\+?3?8?(0[\s\.-]\d{2}[\s\.-]\d{3}[\s\.-]\d{2}[\s\.-]\d{2})$')
);

CREATE TABLE users(
	id_user INT PRIMARY KEY,
	role_id INT REFERENCES roles(id_role),
	user_name VARCHAR NOT NULL,
	surname VARCHAR NOT NULL,
	balance DECIMAL(10, 2),
	email VARCHAR CHECK(email ~* '^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$'),
	mobile VARCHAR CHECK (mobile ~* '^\+?3?8?(0[\s\.-]\d{2}[\s\.-]\d{3}[\s\.-]\d{2}[\s\.-]\d{2})$'),
	subscription_id INT REFERENCES subscriptions(id_subscription)
);

CREATE TABLE appartment(
	id_appartment INT PRIMARY KEY,
	owner_id INT REFERENCES users(id_user),
	teritory_size DECIMAL(10, 2) CHECK(teritory_size > 0),
	price DECIMAL(10, 2) CHECK(price >= 0),
	description VARCHAR NOT NULL,
	max_people INT CHECK (max_people > 2)
);

CREATE TABLE noise_meters(
	id_noise_meter INT PRIMARY KEY,
	appartment INT REFERENCES appartment(id_appartment)
);

CREATE TABLE booking(
	user_id INT REFERENCES users(id_user),
	appartment_id INT REFERENCES appartment(id_appartment),
	PRIMARY KEY(user_id, appartment_id),
	start_time TIME
);
