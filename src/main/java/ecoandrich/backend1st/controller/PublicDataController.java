package ecoandrich.backend1st.controller;
import ecoandrich.backend1st.common.Response.ApiResponse;

import ecoandrich.backend1st.dto.BsDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface PublicDataController {

    ResponseEntity<ApiResponse<Page<BsDto>>> getBsData(int page, int size);

    ResponseEntity<ApiResponse<Void>> saveImage();


}
