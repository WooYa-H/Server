package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.dto.Gongjeong.TeamMemberDTO;

import java.util.List;

public interface TeamMemberService {

    TeamMember createTemMember(CreateTeamMemberDTO.Request request);

    TeamMemberDTO getTeamMember(Long id);

    List<TeamMember> getAllTeamMember();

    void deleteTeamMember(Long id);
}
