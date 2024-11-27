package ecoandrich.backend1st.dto;

import ecoandrich.backend1st.domain.JobHistory;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EmployeeHistoryDto(
        Integer employeeId,

        LocalDate startDate,

        LocalDate endDate,

        String job,

        String department
) {
    public static EmployeeHistoryDto from(JobHistory jobHistory) {
        return EmployeeHistoryDto.builder()
                .employeeId(jobHistory.getId().getEmployeeId())  // 복합키에서 employeeId 가져오기
                .startDate(jobHistory.getId().getStartDate())  // 복합키에서 startDate 가져오기
                .endDate(jobHistory.getEndDate())
                .job(jobHistory.getJob().getJobTitle())  // Job 엔티티에서 job title 가져오기
                .department(jobHistory.getDepartment().getDepartmentName())  // Department 엔티티에서 department name 가져오기
                .build();
    }
}
