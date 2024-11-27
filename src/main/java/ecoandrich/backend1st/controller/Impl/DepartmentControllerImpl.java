package ecoandrich.backend1st.controller.Impl;
import ecoandrich.backend1st.common.Response.ApiResponse;
import ecoandrich.backend1st.controller.DepartmentController;
import ecoandrich.backend1st.dto.DepartmentDto;
import ecoandrich.backend1st.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentControllerImpl implements DepartmentController {
    private final DepartmentService departmentService;

    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_PAGE_NUM = "0";

    @GetMapping("/info")
    public ResponseEntity<ApiResponse<Page<DepartmentDto>>> getDepartmentInfo(@RequestParam(defaultValue = DEFAULT_PAGE_NUM) int page,
                                                                        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size) {
        return ResponseEntity.ok(ApiResponse.success(departmentService.getDepartmentInfo(PageRequest.of(page,size))));
    }


    @PutMapping("/{departmentId}/salary/increase")
    public ResponseEntity<ApiResponse<Void>> increaseSalaryByPercentage(
            @PathVariable Integer departmentId, @RequestParam Double percentage) {
        departmentService.increaseSalaryByPercentage(departmentId, percentage);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}