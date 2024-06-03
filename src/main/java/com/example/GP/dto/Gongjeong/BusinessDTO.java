package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessDTO {

    private Long id;

    private String businessName;

    private String agency;

    private List<TeamDTO> teamDTOList;

    public BusinessDTO(Business business, List<TeamDTO> teamDTOList) {
        this.id = business.getId();
        this.businessName = business.getBusinessName();
        this.agency = business.getAgency();
        this.teamDTOList = teamDTOList;
    }

    public BusinessDTO(Business business) {
        this.id = business.getId();
        this.businessName = business.getBusinessName();
        this.agency = business.getAgency();
    }
}
