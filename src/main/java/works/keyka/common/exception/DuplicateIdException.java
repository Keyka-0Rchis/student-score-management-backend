package works.keyka.common.exception;

import org.springframework.http.HttpStatus;

import works.keyka.common.ErrorCode;

public class DuplicateIdException extends RuntimeException{
	private final ErrorCode errorCode;
	
	public DuplicateIdException(String message,ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public HttpStatus getStatus() {
		return errorCode.getStatus();
	}
}
