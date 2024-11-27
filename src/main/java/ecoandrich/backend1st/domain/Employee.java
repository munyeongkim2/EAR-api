package ecoandrich.backend1st.domain;

import ecoandrich.backend1st.dto.UpdateEmployeeRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;


    public void update(UpdateEmployeeRequest request, Employee manager, Department department, Job job) {
        this.firstName = request.firstName();
        this.lastName = request.lastName();
        this.email = request.email();
        this.phoneNumber = request.phoneNumber();
        this.hireDate = request.hireDate();
        this.salary = request.salary();
        this.commissionPct = request.commissionPct();
        this.manager = manager;
        this.department = department;
        this.job = job;
    }

    public void updateSalary(BigDecimal salary) {
        this.salary = salary;
    }
}