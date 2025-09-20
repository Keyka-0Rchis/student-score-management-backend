package works.keyka.model;

import lombok.Data;

@Data
public class ExamResultModel {
	private int studentID;
	private int examTypeID;
	private int subjectID;
	private int point;
}
