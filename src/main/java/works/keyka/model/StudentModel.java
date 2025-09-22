package works.keyka.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentModel {
	private int studentId;	//20250001のような8桁。
	private int firstGradeNum;
	private int secondGradeNum;
	private int thirdGradeNum;
	private String name;
	private LocalDate birthDate;
	private boolean graduationFlag;
}
