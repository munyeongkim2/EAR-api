package ecoandrich.backend1st.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

	// 400 BAD REQUEST
	INVALID_REQUEST_ARGUMENT(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
	MISSING_PARAMETER(HttpStatus.BAD_REQUEST, "파라미터를 확인 해 주세요."),

	// 404 NOT FOUND
	EMPLOYEE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 직원이 존재하지 않습니다."),
	MANAGER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 매니저가 존재하지 않습니다."),
	DEPARTMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 부서가 존재하지 않습니다."),
	JOB_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 직업이 존재하지 않습니다."),

	// 409 CONFLICT
	DUPLICATED_VALUE(HttpStatus.CONFLICT, "중복된 값입니다."),

	// 500 INTERNAL SERVER ERROR
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부에 문제가 발생했습니다."),
	FEIGN_CLIENT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "FeignClient 통신 문제가 발생했습니다."),
	FAILED_CONVERSION(HttpStatus.INTERNAL_SERVER_ERROR, "Dto로 변환 하는데 실패했습니다.");


	private final HttpStatus statusCode;


	private final String message;


	ErrorCode(HttpStatus statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
}