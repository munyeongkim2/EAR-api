package ecoandrich.backend1st.service;

import ecoandrich.backend1st.dto.BsDto;
import ecoandrich.backend1st.dto.PublicDataResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PublicDataService {

    void save();

    Page<BsDto> getBsData(Pageable pageable);

    ResponseEntity<PublicDataResponse> getPublicData(String secretKey, String type);
}
