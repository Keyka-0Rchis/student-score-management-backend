CREATE TABLE students(
	student_id VARCHAR(8) PRIMARY KEY,
	firstGradeNum int,
	secondGradeNum int,
	thirdGradeNum int,
	name VARCHAR(100) NOT NULL,
	birth_date DATE,
	graduation_flag BOOLEAN
);
