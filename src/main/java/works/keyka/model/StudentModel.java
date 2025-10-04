package works.keyka.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentModel {
	@NotEmpty
	@Pattern(regexp = "\\d{8}") //数字8桁で構成
	private String studentId;	//20250001のような8桁。DBでCHAR(8)としたため文字列で。
	@Min(1000)
	@Max(9999)
	private int firstGradeNum;
	@Min(1000)
	@Max(9999)
	private int secondGradeNum;
	@Min(1000)
	@Max(9999)
	private int thirdGradeNum;
	@Size(max=100)
	private String name;
	@Past						//未来に生まれることはないこととする
	private LocalDate birthDate;
	
	private boolean graduationFlag;
}
