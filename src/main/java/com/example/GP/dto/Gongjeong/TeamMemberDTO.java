package com.example.GP.dto.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMemberDTO {
    
    private Long id;
    
    private String teamRank;
    
    public TeamMemberDTO(TeamMember teamMember) {
        this.id = teamMember.getId();
        this.teamRank = teamMember.getTeamRank();
    }
}
