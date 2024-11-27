package ecoandrich.backend1st.repository;

import ecoandrich.backend1st.domain.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("SELECT d FROM Department d " +
            "JOIN FETCH d.location l " +
            "JOIN FETCH l.country c " +
            "JOIN FETCH c.region r")
    Page<Department> findAllWithLocation(Pageable pageable);
}
