package ecoandrich.backend1st.service.impl;

import ecoandrich.backend1st.common.exception.NotFoundException;
import ecoandrich.backend1st.domain.Department;
import ecoandrich.backend1st.domain.Employee;
import ecoandrich.backend1st.domain.Job;
import ecoandrich.backend1st.domain.JobHistory;
import ecoandrich.backend1st.dto.EmployeeDto;
import ecoandrich.backend1st.dto.EmployeeHistoryDto;
import ecoandrich.backend1st.dto.UpdateEmployeeRequest;
import ecoandrich.backend1st.repository.DepartmentRepository;
import ecoandrich.backend1st.repository.EmployeeRepository;
import ecoandrich.backend1st.repository.JobHistoryRepository;
import ecoandrich.backend1st.repository.JobRepository;
import ecoandrich.backend1st.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static ecoandrich.backend1st.common.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final JobHistoryRepository jobHistoryRepository;
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;

    @Transactional(readOnly = true)
    public List<EmployeeHistoryDto> getEmployeeHistory(Integer employeeId) {

        List<JobHistory> jobHistories = jobHistoryRepository.findJobHistoryWithJobAndDepartment(employeeId);

        return jobHistories.stream()
                .map(EmployeeHistoryDto::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeCurrentInfo(Integer employeeId) {
        Employee employee = employeeRepository.findEmployeeById(employeeId)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));

        return EmployeeDto.from(employee);

    }

    public void update(Integer employeeId, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));

        Department department = departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new NotFoundException(DEPARTMENT_NOT_FOUND));

        Job job = jobRepository.findById(request.jobId())
                .orElseThrow(() -> new NotFoundException(JOB_NOT_FOUND));

        Employee manager = null;
        if (request.managerId() != null) {
            manager = employeeRepository.findById(request.managerId())
                    .orElseThrow(() -> new NotFoundException(MANAGER_NOT_FOUND));
        }

        employee.update(request, manager, department, job);
    }
}
