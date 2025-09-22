package works.keyka.model;

import lombok.Data;

@Data
public class UserModel {
	private int userID;
	private int userSubjectID;
	private int userRollID;
	private String userName;
	private String password;
}
