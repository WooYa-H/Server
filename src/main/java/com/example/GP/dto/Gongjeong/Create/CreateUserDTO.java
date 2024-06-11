package com.example.GP.dto.Gongjeong.Create;

import com.example.GP.domain.Gongjeong.User;
import lombok.*;

public class CreateUserDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        @NonNull
        private String name;

        @NonNull
        private String phoneNumber;

        @NonNull
        private Long companyId;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String ok;

        public static CreateUserDTO.Response from(User user) {

            return Response.builder()
                    .id(user.getId())
                    .ok("계정이 생성 완료되었습니다.")
                    .build();
        }
    }
}
