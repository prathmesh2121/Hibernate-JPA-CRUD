-- Step 1: Create the database (schema)
CREATE DATABASE IF NOT EXISTS student_tracker;

-- Step 2: Use that database
USE student_tracker;

-- Step 3: Drop the table if it already exists
DROP TABLE IF EXISTS student;

-- Step 4: Create the table
CREATE TABLE student (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) DEFAULT NULL,
  last_name VARCHAR(45) DEFAULT NULL,
  email VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
