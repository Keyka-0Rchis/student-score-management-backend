package works.keyka.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import works.keyka.common.ErrorCode;
import works.keyka.common.exception.DuplicateIdException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // BeanValidation(@Valid) のエラー
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(HandlerMethodValidationException ex) {
        List<Map<String, String>> details = ex.getAllErrors().stream()
            .map(error -> {
                Map<String, String> map = new HashMap<>();
                if (error instanceof FieldError fieldError) {
                    map.put("field", fieldError.getField());
                    map.put("rejectedValue", String.valueOf(fieldError.getRejectedValue()));
                }
                map.put("message", error.getDefaultMessage());
                return map;
            })
            .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("ErrorCode", ErrorCode.VALIDATION_ERROR.getCode());
        response.put("Message", "入力内容に誤りがあります");
        // HandlerMethodValidationExceptionが標準的に持っている各フィールドのエラー情報（field, message, rejected value）を入れる
        response.put("Details", details);

        return ResponseEntity.badRequest().body(response);
    }
	
    // ID重複
    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<Map<String, String>> handleDuplicate(DuplicateIdException ex) {
    	Map<String, String> errors = new HashMap<>();
    	errors.put("ErrorCode", ex.getErrorCode().getCode());
    	errors.put("Message",ex.getMessage());
	    return ResponseEntity.badRequest().body(errors);
    }
}
