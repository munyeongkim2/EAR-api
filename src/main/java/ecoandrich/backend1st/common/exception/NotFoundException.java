package ecoandrich.backend1st.common.exception;

public class NotFoundException extends HrException {

	public NotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
