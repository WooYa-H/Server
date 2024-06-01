package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    private Long id;

    private String teamName;

    private String leader;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.teamName = team.getTeamName();
        this.leader = team.getLeader();

    }
}
