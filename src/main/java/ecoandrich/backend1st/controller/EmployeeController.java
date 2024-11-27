package ecoandrich.backend1st.controller;

import ecoandrich.backend1st.common.Response.ApiResponse;
import ecoandrich.backend1st.dto.EmployeeDto;
import ecoandrich.backend1st.dto.EmployeeHistoryDto;
import ecoandrich.backend1st.dto.UpdateEmployeeRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeController {

    ResponseEntity<ApiResponse<List<EmployeeHistoryDto>>> getEmployeeHistory(@PathVariable Integer employeeId);

    ResponseEntity<ApiResponse<EmployeeDto>> getEmployeeCurrentInfo(@PathVariable Integer employeeId);

    ResponseEntity<ApiResponse<Void>> updateEmployee(@PathVariable Integer employeeId, @RequestBody @Valid UpdateEmployeeRequest request);

}