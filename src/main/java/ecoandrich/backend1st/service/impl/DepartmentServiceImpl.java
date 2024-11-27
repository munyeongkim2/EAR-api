package ecoandrich.backend1st.service.impl;

import ecoandrich.backend1st.common.exception.NotFoundException;
import ecoandrich.backend1st.domain.Department;
import ecoandrich.backend1st.dto.DepartmentDto;
import ecoandrich.backend1st.repository.DepartmentRepository;
import ecoandrich.backend1st.repository.EmployeeRepository;
import ecoandrich.backend1st.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static ecoandrich.backend1st.common.exception.ErrorCode.DEPARTMENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<DepartmentDto> getDepartmentInfo(PageRequest pageRequest) {
        Page<Department> departments = departmentRepository.findAllWithLocation(pageRequest);
        return departments.map(DepartmentDto::from);
    }

    public void increaseSalaryByPercentage(Integer departmentId, Double percentage) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NotFoundException(DEPARTMENT_NOT_FOUND));

        BigDecimal percentageMultiplier = BigDecimal.valueOf(1 + (percentage / 100.0));

        employeeRepository.updateSalariesByDepartment(department, percentageMultiplier);

    }
}
