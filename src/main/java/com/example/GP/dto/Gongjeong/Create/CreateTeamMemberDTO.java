package com.example.GP.dto.Gongjeong.Create;

import com.example.GP.domain.Gongjeong.TeamMember;
import lombok.*;

public class CreateTeamMemberDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long teamId;

        private String teamRank;

        private String employeeNumber;

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

        public static Response from (TeamMember teamMember) {
            return Response.builder()
                    .id(teamMember.getId())
                    .teamRank(teamMember.getTeamRank())
                    .ok("생성 완료")
                    .build();
        }
    }

}
