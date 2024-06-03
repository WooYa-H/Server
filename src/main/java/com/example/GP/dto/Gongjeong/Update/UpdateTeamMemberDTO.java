package com.example.GP.dto.Gongjeong.Update;

import com.example.GP.domain.Gongjeong.TeamMember;
import lombok.*;

public class UpdateTeamMemberDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String teamRank;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String teamRank;

        private String ok;


        public static Response from(TeamMember teamMember) {

            return Response.builder()
                    .id(teamMember.getId())
                    .teamRank(teamMember.getTeamRank())
                    .ok("수정 완료")
                    .build();
        }
    }

}

