ALTER TABLE tweets
    ADD CONSTRAINT fk_user_tweets FOREIGN KEY (user_id) REFERENCES users (id);