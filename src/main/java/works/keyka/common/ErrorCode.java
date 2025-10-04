package works.keyka.common;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
	//不正な文字列
	VALIDATION_ERROR("E001",HttpStatus.BAD_REQUEST),
	//IDの重複
	DUPLICATE_ID("E002",HttpStatus.BAD_REQUEST),
	//データベースの不具合
	DB_ERROR("E500",HttpStatus.BAD_GATEWAY),
	//その他原因不明
	UNKNOWN_ERROR("E999",HttpStatus.INTERNAL_SERVER_ERROR);
	
	private final String code;
	private final HttpStatus status;
	
	ErrorCode(String code,HttpStatus status) {
		this.code = code;
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}
