package ecoandrich.backend1st.repository;

import ecoandrich.backend1st.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {

}
