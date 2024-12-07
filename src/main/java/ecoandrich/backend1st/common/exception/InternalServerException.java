package ecoandrich.backend1st.common.exception;

public class InternalServerException extends HrException {
	public InternalServerException(ErrorCode errorCode) {
		super(errorCode);
	}
}
