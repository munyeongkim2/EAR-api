package ecoandrich.backend1st.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id", nullable = false)
    private Character countryId;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

}