package ecoandrich.backend1st.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "emp_details_view")
public class EmpDetailsView {

    @Id
    private Integer employeeId;

    private String jobId;

    private Integer managerId;

    private Integer departmentId;

    private Integer locationId;

    private Character countryId;

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    private BigDecimal commissionPct;

    private String departmentName;

    private String jobTitle;

    private String city;

    private String stateProvince;

    private String countryName;

    private String regionName;
}
