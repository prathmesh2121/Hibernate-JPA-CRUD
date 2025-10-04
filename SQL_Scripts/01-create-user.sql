Drop user if exists 'springstudent'@'localhost';

create user 'springstudent'@'localhost' identified by 'springstudent';

grant all privileges on * . * to 'springstudent'@'localhost';