package ecoandrich.backend1st.common.exception;

import lombok.Getter;

@Getter
public abstract class HrException extends RuntimeException {

    private final ErrorCode errorCode;

	protected HrException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

}
