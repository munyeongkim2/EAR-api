package ecoandrich.backend1st.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ecoandrich.backend1st.domain.Bs;

import java.util.List;

public record BsListDto(
        List<BsDto> bs
) {

}