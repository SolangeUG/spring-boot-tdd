-- Database: testdb

CREATE TABLE IF NOT EXISTS cars (
    id LONG PRIMARY KEY auto_increment,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
);
