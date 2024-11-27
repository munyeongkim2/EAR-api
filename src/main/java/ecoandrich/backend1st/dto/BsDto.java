package ecoandrich.backend1st.dto;

import ecoandrich.backend1st.domain.Bs;
import lombok.Builder;

@Builder
public record BsDto(
              Long bsId,
              String bsNm
) {

    public static BsDto of(Bs bs) {
        return BsDto.builder().bsId(bs.getBsId()).bsNm(bs.getBsName()).build();
    }
}
