CREATE TABLE tweets (
    id SERIAL PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    user_id INT NOT NULL
);