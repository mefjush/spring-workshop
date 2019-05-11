INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$WxTfHiEfVjv9.YFvFyrvme8ybSn0bV/dCqvkkOmdaDaM/tmcImTyG', true); --user:password
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$4TYHFQRWQjk/.SpCUvhV7e.3n6K4bF0.J.c9dvEaRzRjuKBlxBfBm', true); --admin:admin
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO wallet_entry (id, currency, change) VALUES (-1, 'EUR', 1000);
INSERT INTO wallet_entry (id, currency, change) VALUES (-2, 'PLN', 1000);