package ecoandrich.backend1st.repository;


import ecoandrich.backend1st.domain.Department;
import ecoandrich.backend1st.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e " +
            "JOIN FETCH e.manager m " +
            "JOIN FETCH e.department d " +
            "JOIN FETCH e.job j " +
            "WHERE e.employeeId = :employeeId")
    Optional<Employee> findEmployeeById(@Param("employeeId") Integer employeeId);

    @Modifying
    @Query("UPDATE Employee e " +
            "SET e.salary = e.salary * :increasePercentage " +
            "WHERE e.department = :department")
    void updateSalariesByDepartment(@Param("department") Department department,
                                    @Param("increasePercentage") BigDecimal increasePercentage);
}
