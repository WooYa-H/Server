package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Company;
import lombok.*;


public class CreateCompanyDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private String name;

        private String ceo;

        private String address;

        private String businessNumber;

        private String email;

        private String phoneNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;
        private String ok;

        public static Response from(Company company) {
            return Response.builder()
                    .id(company.getId())
                    .ok("ok")
                    .build();
        }
    }

}
