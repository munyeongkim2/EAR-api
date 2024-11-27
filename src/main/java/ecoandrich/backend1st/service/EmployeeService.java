package ecoandrich.backend1st.service;

import ecoandrich.backend1st.dto.EmployeeDto;
import ecoandrich.backend1st.dto.EmployeeHistoryDto;
import ecoandrich.backend1st.dto.UpdateEmployeeRequest;
import java.util.List;

public interface EmployeeService {
    List<EmployeeHistoryDto> getEmployeeHistory(Integer employeeId);

    EmployeeDto getEmployeeCurrentInfo(Integer employeeId);

    void update(Integer employeeId, UpdateEmployeeRequest request);
}
