package ecoandrich.backend1st.common.handler;

import ecoandrich.backend1st.common.Response.ApiResponse;
import ecoandrich.backend1st.common.Response.ErrorResponse;
import ecoandrich.backend1st.common.Response.ValidErrorResponse;
import ecoandrich.backend1st.common.exception.ErrorCode;
import ecoandrich.backend1st.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("MethodArgumentNotValidException: {} | Location: {}", exception.getMessage(), getLocation(exception),
                exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidErrorResponse.from(exception));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handle(NotFoundException exception) {
        log.error("NotFoundException: {} | Location: {}", exception.getMessage(), getLocation(exception), exception);
        ErrorResponse errorResponse = ErrorResponse.from(exception);
        return ResponseEntity.status(errorResponse.errorCode().getStatusCode()).body(ApiResponse.error(errorResponse));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception exception) {
        log.error("NoHandlerFoundException: {} | Location: {}", exception.getMessage(), getLocation(exception), exception);
        ErrorResponse errorResponse = ErrorResponse.from(ErrorCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(errorResponse.errorCode().getStatusCode()).body(errorResponse);
    }

    static public String getLocation(Throwable exception) {
        StackTraceElement element = exception.getStackTrace()[0];
        return String.format("%s.%s(%s:%d)", element.getClassName(), element.getMethodName(), element.getFileName(),
                element.getLineNumber());
    }
}
