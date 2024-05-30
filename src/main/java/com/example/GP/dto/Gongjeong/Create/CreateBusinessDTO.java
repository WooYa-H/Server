package com.example.GP.dto.Gongjeong.Create;

import com.example.GP.domain.Gongjeong.Business;
import lombok.*;

public class CreateBusinessDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private String businessName;

        private String agency;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String ok;

        private String businessName;

        public static Response from(Business business) {
            return Response.builder()
                    .id(business.getId())
                    .businessName(business.getBusinessName())
                    .ok("생성 완료")
                    .build();
        }
    }
}
