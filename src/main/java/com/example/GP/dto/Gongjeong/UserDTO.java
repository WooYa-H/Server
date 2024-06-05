package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import com.example.GP.domain.Gongjeong.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private CompanyDTO.UserResponse company;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.company = CompanyDTO.UserResponse.builder()
                .id(user.getCompany().getId())
                .name(user.getCompany().getName())
                .build();
    }
}
