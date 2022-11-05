CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    birthday VARCHAR(255),
    gender VARCHAR(255),
    bio VARCHAR(255),
    location VARCHAR(255),
    website VARCHAR(255)
);