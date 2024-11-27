package ecoandrich.backend1st.common.Response;

import ch.qos.logback.core.spi.ErrorCodes;
import ecoandrich.backend1st.common.exception.ErrorCode;
import ecoandrich.backend1st.common.exception.HrException;

public record ErrorResponse(
        ErrorCode errorCode,
        String message
) {
    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(errorCode, errorCode.getMessage());

    }

    public static ErrorResponse from(Exception exception) {
        return new ErrorResponse(ErrorCode.INVALID_REQUEST_ARGUMENT, exception.getMessage());
    }

    public static ErrorResponse from(HrException hrException) {
        return ErrorResponse.from(hrException.getErrorCode());
    }



}
