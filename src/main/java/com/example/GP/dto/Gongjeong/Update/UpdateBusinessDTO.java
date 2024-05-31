package com.example.GP.dto.Gongjeong.Update;

import com.example.GP.domain.Gongjeong.Business;
import lombok.*;

public class UpdateBusinessDTO {


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String businessName;

        private String agency;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String businessName;

        private String agency;

        private String ok;

        public static Response from(Business business) {

            return Response.builder()
                    .id(business.getId())
                    .businessName(business.getBusinessName())
                    .agency(business.getAgency())
                    .ok("수정 완료")
                    .build();
        }
    }
}
