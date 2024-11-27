package ecoandrich.backend1st.dto;

import ecoandrich.backend1st.domain.Employee;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record EmployeeDto(
        Integer employeeId,
        String employeeName,
        String email,
        String phoneNumber,
        LocalDate hireDate,
        BigDecimal salary,
        BigDecimal commissionPct,
        String managerName,
        String department,
        String job
) {
    public static EmployeeDto from(Employee employee) {
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstName() + " " + employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getCommissionPct(),
                employee.getManager() != null ? employee.getManager().getFirstName() + " " + employee.getManager().getLastName() : null,
                employee.getDepartment().getDepartmentName(),
                employee.getJob().getJobTitle()
        );
    }

}
