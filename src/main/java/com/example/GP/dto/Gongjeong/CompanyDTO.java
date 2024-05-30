package com.example.GP.dto.Gongjeong;


import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.domain.Gongjeong.Department;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDTO {

    private Long id;

    private String name;

    private String ceo;

    private String address;

    private String businessNumber;

    private String email;

    private String phoneNumber;

    private List<DepartmentDTO> departmentList;

    public CompanyDTO(Company company, List<DepartmentDTO> departmentList) {
        this.id = company.getId();
        this.name = company.getName();
        this.ceo = company.getCeo();
        this.address = company.getAddress();
        this.businessNumber = company.getBusinessNumber();
        this.email = company.getEmail();
        this.phoneNumber = company.getPhoneNumber();
        this.departmentList = departmentList;
    }
}
