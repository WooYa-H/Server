package com.example.GP.dto.Gongjeong.Update;

import com.example.GP.domain.Gongjeong.Company;
import lombok.*;

public class UpdateCompanyDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String name;

        private String ceo;

        private String address;

        private String businessNumber;

        private String email;

        private String phoneNumber;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String name;

        private String ceo;

        private String address;

        private String businessNumber;

        private String email;

        private String phoneNumber;

        public static Response from(Company company) {

            return Response.builder()
                    .id(company.getId())
                    .name(company.getName())
                    .ceo(company.getCeo())
                    .address(company.getAddress())
                    .businessNumber(company.getBusinessNumber())
                    .email(company.getEmail())
                    .phoneNumber(company.getPhoneNumber())
                    .build();
        }
    }
}