package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.dto.Gongjeong.TeamMemberDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateTeamMemberDTO;

import java.util.List;

public interface TeamMemberService {

    TeamMember createTeamMember(CreateTeamMemberDTO.Request request);

    TeamMemberDTO getTeamMember(Long id);

    List<TeamMember> getAllTeamMember();

    void deleteTeamMember(Long id);

    TeamMember updateTeamMember(UpdateTeamMemberDTO.Request request);
}
