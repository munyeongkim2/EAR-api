package ecoandrich.backend1st.common.Response;

import ecoandrich.backend1st.common.exception.ErrorCode;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public record ValidErrorResponse(ErrorCode errorCode, String message, Map<String, String> result) {

	public static ValidErrorResponse from(MethodArgumentNotValidException e) {
		Map<String, String> result = e.getBindingResult()
			.getFieldErrors()
			.stream()
			.collect(toMap(FieldError::getField, ValidErrorResponse::getFieldErrorMessage));
		return new ValidErrorResponse(ErrorCode.INVALID_REQUEST_ARGUMENT,
			ErrorCode.INVALID_REQUEST_ARGUMENT.getMessage(), result);
	}

	private static String getFieldErrorMessage(FieldError error) {
		String message = error.getDefaultMessage();
		if (message == null) {
			return "잘못된 요청입니다.";
		}
		return message;
	}
}
