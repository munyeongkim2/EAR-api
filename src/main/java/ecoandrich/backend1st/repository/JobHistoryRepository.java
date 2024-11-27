package ecoandrich.backend1st.repository;

import ecoandrich.backend1st.domain.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
        @Query("SELECT jh FROM JobHistory jh " +
                "JOIN FETCH jh.job j " +
                "JOIN FETCH jh.department d " +
                "WHERE jh.id.employeeId = :employeeId")
        List<JobHistory> findJobHistoryWithJobAndDepartment(@Param("employeeId") Integer employeeId);

}
