package ecoandrich.backend1st.dto;


import ecoandrich.backend1st.domain.Department;
import ecoandrich.backend1st.domain.Location;
import lombok.Builder;

@Builder
public record DepartmentDto(
         String departmentName,
         String address
) {

    public static DepartmentDto from(Department department) {
        String address = department.getLocation().getPostalCode() + ", " +
                department.getLocation().getStreetAddress() + ", " +
                department.getLocation().getCity() + ", " +
                department.getLocation().getStateProvince() + ", " +
                department.getLocation().getCountry().getCountryName() + ", " +
                department.getLocation().getCountry().getRegion().getName();

        return DepartmentDto.builder()
                .departmentName(department.getDepartmentName())
                .address(address)
                .build();
    }

}
