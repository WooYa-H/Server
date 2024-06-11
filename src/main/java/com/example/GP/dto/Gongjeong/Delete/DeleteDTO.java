package com.example.GP.dto.Gongjeong.Delete;

import jakarta.validation.constraints.NotNull;
import lombok.*;

public class DeleteDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        @NotNull
        private Long id;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private String ok;

        public static DeleteDTO.Response from() {
            return DeleteDTO.Response.builder()
                    .ok("삭제 완료")
                    .build();
        }
    }
}
