DROP ALL OBJECTS;
create table if not exists weather_check(id SERIAL, location VARCHAR(255), scale VARCHAR(1));
create table if not exists weather_book(id SERIAL, location VARCHAR(255), temperature INT, scale VARCHAR(1));
