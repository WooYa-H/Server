package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTOS {

    private Long id;

    private String teamName;

    private String leader;

    private List<TeamMemberDTO> teamMemberDTOList;

    public TeamDTOS(Team team, List<TeamMemberDTO> teamMemberDTOList) {
        this.id = team.getId();
        this.teamName = team.getTeamName();
        this.leader = team.getLeader();
        this.teamMemberDTOList = teamMemberDTOList;

    }
}
