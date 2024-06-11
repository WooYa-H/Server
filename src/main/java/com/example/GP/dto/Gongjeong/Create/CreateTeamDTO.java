package com.example.GP.dto.Gongjeong.Create;

import com.example.GP.domain.Gongjeong.Team;
import lombok.*;

public class CreateTeamDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        @NonNull
        private String teamName;

        private String leader;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String teamName;

        private String ok;

        public static Response from(Team team) {
            return Response.builder()
                    .id(team.getId())
                    .teamName(team.getTeamName())
                    .ok("생성 완료")
                    .build();
        }
    }
}
