package com.example.GP.dto.Gongjeong;

import lombok.*;

public class DeleteDepartmentDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long departmentId;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private String ok;

        public static Response from() {
            return Response.builder()
                    .ok("삭제 완료")
                    .build();
        }
    }
}
