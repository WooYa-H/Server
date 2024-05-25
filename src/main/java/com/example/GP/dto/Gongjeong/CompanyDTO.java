package com.example.GP.dto.Gongjeong;


import com.example.GP.domain.Gongjeong.Company;
import lombok.*;

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

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.ceo = company.getCeo();
        this.address = company.getAddress();
        this.businessNumber = company.getBusinessNumber();
        this.email = company.getEmail();
        this.phoneNumber = company.getPhoneNumber();
    }
}
