package ecoandrich.backend1st.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;


@Embeddable
@Getter
public class JobHistoryId implements Serializable {

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

}

