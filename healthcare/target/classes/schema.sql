DROP TABLE IF EXISTS t_usr_enroll;

CREATE TABLE t_usr_enroll
   ( id NUMBER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    act_status BOOLEAN NOT NULL,
	dob DATE NOT NULL,
	phone_num VARCHAR(32));
	
CREATE TABLE t_usr_dep
   ( id NUMBER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,    
	dob DATE NOT NULL);