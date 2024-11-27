package ecoandrich.backend1st.controller.Impl;

import ecoandrich.backend1st.common.Response.ApiResponse;
import ecoandrich.backend1st.controller.PublicDataController;
import ecoandrich.backend1st.dto.BsDto;
import ecoandrich.backend1st.service.PublicDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public-data")
@RequiredArgsConstructor
public class PublicDataControllerImpl implements PublicDataController {

    private final PublicDataService publicDataService;

    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_PAGE_NUM = "0";

    @GetMapping
    public ResponseEntity<ApiResponse<Page<BsDto>>> getBsData(@RequestParam(defaultValue = DEFAULT_PAGE_NUM) int page,
                                                        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size) {
        return ResponseEntity.ok(ApiResponse.success(publicDataService.getBsData(PageRequest.of(page,size))));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> saveImage(){
        publicDataService.save();
        return ResponseEntity.ok(ApiResponse.success(null));
    }


}
