package ecoandrich.backend1st.common.exception;

public class FeignClientException extends HrException {
    public FeignClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
