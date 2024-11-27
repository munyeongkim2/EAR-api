package ecoandrich.backend1st.service;

import ecoandrich.backend1st.dto.DepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DepartmentService {

    Page<DepartmentDto> getDepartmentInfo(PageRequest pageRequest);

    void increaseSalaryByPercentage(Integer departmentId, Double percentage);
}
