package ecoandrich.backend1st.controller;
import ecoandrich.backend1st.common.Response.ApiResponse;
import ecoandrich.backend1st.dto.DepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface DepartmentController {

    ResponseEntity<ApiResponse<Page<DepartmentDto>>> getDepartmentInfo(int page,int size);

    ResponseEntity<Void> increaseSalaryByPercentage(Integer departmentId, Double percentage);
}