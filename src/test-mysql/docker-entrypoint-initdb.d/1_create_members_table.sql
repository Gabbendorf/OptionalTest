USE test_db;

DROP TABLE IF EXISTS members;

CREATE TABLE members (
    member_id int(11) UNIQUE,
    name varchar(100),
    surname varchar(100)
);