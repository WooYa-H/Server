package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;

public interface TeamMemberService {

    TeamMember createTemMember(CreateTeamMemberDTO.Request request);
}
