package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessDTO {

    private Long id;

    private String businessName;

    private String agency;

    public BusinessDTO(Business business) {
        this.id = business.getId();
        this.businessName = business.getBusinessName();
        this.agency = business.getAgency();
    }
}
