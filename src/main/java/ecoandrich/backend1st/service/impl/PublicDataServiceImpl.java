package ecoandrich.backend1st.service.impl;

import ecoandrich.backend1st.client.PublicDataClient;
import ecoandrich.backend1st.common.exception.ErrorCode;
import ecoandrich.backend1st.common.exception.FeignClientException;
import ecoandrich.backend1st.common.exception.NotFoundException;
import ecoandrich.backend1st.domain.Bs;
import ecoandrich.backend1st.dto.BsDto;
import ecoandrich.backend1st.dto.PublicDataResponse;
import ecoandrich.backend1st.repository.BsRepository;
import ecoandrich.backend1st.service.PublicDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PublicDataServiceImpl implements PublicDataService {
    private final PublicDataClient publicDataClient;
    private final BsRepository bsRepository;

    @Value("${api.public-data.service-key}")
    private String secretKey;

    @Value("${api.public-data.type}")
    private String type;

    public void save(){
        ResponseEntity<PublicDataResponse> response = getPublicData(secretKey, type);

        PublicDataResponse results = response.getBody();
        if (results == null || results.body() == null || results.body().items() == null) {
            throw new NotFoundException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        List<Bs> bsList = results.body().items().bs().stream()
                .map(Bs::of)
                .toList();

        int batchSize = 500;

        for (int i = 0; i < bsList.size(); i += batchSize) {
            int end = Math.min(i + batchSize, bsList.size());
            List<Bs> batch = bsList.subList(i, end);
            bsRepository.saveAll(batch);
        }

    }

    @Transactional(readOnly = true)
    public Page<BsDto> getBsData(Pageable pageable) {
        Page<Bs> bsPage = bsRepository.findAll(pageable);
        return bsPage.map(BsDto::of);
    }

    public ResponseEntity<PublicDataResponse> getPublicData(String secretKey, String type) {
        try {
            return publicDataClient.basic(secretKey, type);
        } catch (FeignClientException feignClientException) {
            throw new FeignClientException(ErrorCode.FEIGN_CLIENT_ERROR);
        }
    }
}
