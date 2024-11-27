package ecoandrich.backend1st.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @Column(name = "region_id", nullable = false)
    private Integer id;

    @Column(name = "region_name")
    private String name;

}
