package ecoandrich.backend1st.domain;

import ecoandrich.backend1st.dto.BsDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "bs")
public class Bs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    Long bsId;

    String bsName;

    @Builder
    public Bs( Long bsId, String bsName) {
        this.bsId = bsId;
        this.bsName = bsName;
    }

    public static Bs of(BsDto bsDto) {
        return Bs.builder().bsId(bsDto.bsId()).bsName(bsDto.bsNm()).build();
    }
}
