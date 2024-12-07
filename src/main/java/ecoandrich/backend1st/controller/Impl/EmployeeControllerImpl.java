package ecoandrich.backend1st.controller.Impl;

import ecoandrich.backend1st.common.Response.ApiResponse;
import ecoandrich.backend1st.controller.EmployeeController;
import ecoandrich.backend1st.dto.EmployeeDto;
import ecoandrich.backend1st.dto.EmployeeHistoryDto;
import ecoandrich.backend1st.dto.UpdateEmployeeRequest;
import ecoandrich.backend1st.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;

    // 특정 사원의 이력 정보 조회
    @GetMapping("/{employeeId}/history")
    public ResponseEntity<ApiResponse<List<EmployeeHistoryDto>>> getEmployeeHistory(@PathVariable Integer employeeId) {
        return ResponseEntity.ok(ApiResponse.success(employeeService.getEmployeeHistory(employeeId)));
    }

    // 특정 사원의 현재 정보 조회
    @GetMapping("/{employeeId}/current")
    public ResponseEntity<ApiResponse<EmployeeDto>> getEmployeeCurrentInfo(@PathVariable Integer employeeId) {
        return ResponseEntity.ok(ApiResponse.success(employeeService.getEmployeeCurrentInfo(employeeId)));
    }

    //사원 정보를 업데이트 할 수 있는 API 구현
    @PutMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<Void>> updateEmployee(@PathVariable Integer employeeId, @RequestBody @Valid UpdateEmployeeRequest request) {
        employeeService.update(employeeId, request);
        return ResponseEntity.noContent().build();
    }

}