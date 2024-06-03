package com.example.GP.dto.Gongjeong.Update;

import com.example.GP.domain.Gongjeong.Team;
import lombok.*;

public class UpdateTeamDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String teamName;

        private String leader;

        private Long businessId;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String teamName;

        private String leader;

        private Long businessId;

        private String ok;

        public static Response from(Team team) {

            return Response.builder()
                    .id(team.getId())
                    .teamName(team.getTeamName())
                    .leader(team.getLeader())
                    .businessId(team.getBusiness().getId())
                    .ok("수정 완료")
                    .build();
        }

    }


    }
