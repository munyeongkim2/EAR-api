package ecoandrich.backend1st.client;


import ecoandrich.backend1st.dto.PublicDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="publicDataClient" , url = "http://apis.data.go.kr/6270000/dbmsapi")
public interface PublicDataClient {

    @GetMapping("/basic")
    ResponseEntity<PublicDataResponse> basic(@RequestParam String serviceKey, @RequestParam String type);

}
