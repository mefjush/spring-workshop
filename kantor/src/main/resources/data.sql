INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$WxTfHiEfVjv9.YFvFyrvme8ybSn0bV/dCqvkkOmdaDaM/tmcImTyG', true); --user:password
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$4TYHFQRWQjk/.SpCUvhV7e.3n6K4bF0.J.c9dvEaRzRjuKBlxBfBm', true); --admin:admin
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO wallet_entry (id, currency, change) VALUES (-1, 'EUR', 1000);
INSERT INTO wallet_entry (id, currency, change) VALUES (-2, 'USD', 1000);
INSERT INTO wallet_entry (id, currency, change) VALUES (-3, 'CZK', 1000);

INSERT INTO currency_order (id, value, currency, rate, user, confirmed) VALUES (-1, 100, 'EUR', 0.25, 'Roman', false);
INSERT INTO currency_order (id, value, currency, rate, user, confirmed) VALUES (-2, 120, 'EUR', 0.25, 'Jadwiga', false);
INSERT INTO currency_order (id, value, currency, rate, user, confirmed) VALUES (-3, 80, 'USD', 0.25, 'Hieronim', false);