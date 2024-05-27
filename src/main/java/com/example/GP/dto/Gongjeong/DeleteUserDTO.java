package com.example.GP.dto.Gongjeong;

import lombok.*;

public class DeleteUserDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private String ok;

        public static DeleteUserDTO.Response from() {
            return DeleteUserDTO.Response.builder()
                    .ok("삭제 완료")
                    .build();
        }
    }
}
