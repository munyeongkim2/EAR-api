package ecoandrich.backend1st.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateEmployeeRequest(
        @NotBlank(message = "이름은 필수 입력 항목입니다.")
        @Size(max = 50, message = "이름은 50자를 초과할 수 없습니다.")
        String firstName,

        @NotBlank(message = "성을 입력해주세요.")
        @Size(max = 50, message = "성은 50자를 초과할 수 없습니다.")
        String lastName,

        @Email(message = "유효한 이메일 주소를 입력해주세요.")
        @NotBlank(message = "이메일은 필수 입력 항목입니다.")
        String email,

        @Pattern(regexp = "^[0-9\\-]+$", message = "전화번호는 숫자와 하이픈만 포함해야 합니다.")
        @Size(max = 15, message = "전화번호는 최대 15자를 초과할 수 없습니다.")
        String phoneNumber,

        @PastOrPresent(message = "입사일은 과거 또는 오늘 날짜여야 합니다.")
        LocalDate hireDate,

        @DecimalMin(value = "0.0", inclusive = false, message = "급여는 0보다 커야 합니다.")
        @Digits(integer = 10, fraction = 2, message = "급여는 최대 10자리 정수와 소수점 이하 2자리까지 가능합니다.")
        BigDecimal salary,

        @DecimalMin(value = "0.0", message = "커미션 비율은 0 이상이어야 합니다.")
        @DecimalMax(value = "1.0", message = "커미션 비율은 1 이하이어야 합니다.")
        BigDecimal commissionPct,

        @Min(value = 1, message = "매니저 ID는 양수여야 합니다.")
        Integer managerId,

        @Min(value = 1, message = "부서 ID는 양수여야 합니다.")
        Integer departmentId,

        @NotBlank(message = "직무 ID는 필수 입력 항목입니다.")
        @Size(max = 10, message = "직무 ID는 10자를 초과할 수 없습니다.")
        String jobId
) {
}
