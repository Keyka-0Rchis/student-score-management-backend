package works.keyka.model;

import lombok.Data;

@Data
public class StudentModel {
	private int studentID;
	private int firstGradeNum;
	private int secondGradeNum;
	private int thirdGradeNum;
	private String name;
	private String birth;
	private boolean graduateFlag;
}
