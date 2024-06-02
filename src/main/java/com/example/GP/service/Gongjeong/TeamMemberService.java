package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.dto.Gongjeong.TeamMemberDTO;

public interface TeamMemberService {

    TeamMember createTemMember(CreateTeamMemberDTO.Request request);

    TeamMemberDTO getTeamMember(Long id);
}
