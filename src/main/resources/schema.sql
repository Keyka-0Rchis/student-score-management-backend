CREATE TABLE IF NOT EXISTS students (
	student_id CHAR(8) PRIMARY KEY,
	firstGradeNum SMALLINT,
	secondGradeNum SMALLINT,
	thirdGradeNum SMALLINT,
	name VARCHAR(100) NOT NULL,
	birth_date DATE,
	graduation_flag BOOLEAN
);
