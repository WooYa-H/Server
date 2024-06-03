package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.dto.Gongjeong.TeamMemberDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateTeamMemberDTO;
import com.example.GP.exception.Gonjeong.TeamMemberException;
import com.example.GP.repository.Gongjeong.TeamMemberRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    //TODO : User 식별로 사번 만들기 - 동일인 구분을 위해서
    public TeamMember createTemMember(CreateTeamMemberDTO.Request request) {

        return teamMemberRepository.save(TeamMember.builder()
                .teamRank(request.getTeamRank())
                .build());
    }

    public TeamMemberDTO getTeamMember(Long id) {

        TeamMember teamMember = teamMemberRepository.findById(id).orElseThrow(
                () -> new TeamMemberException(ErrorCode.TEAM_MEMBER_NOT_FOUND));

        return new TeamMemberDTO(teamMember);
    }

    public List<TeamMember> getAllTeamMember() {

        List<TeamMember> teamMemberDTOList = teamMemberRepository.findAll();

        return teamMemberDTOList;
    }

    public void deleteTeamMember(Long id) {

        teamMemberRepository.findById(id).orElseThrow(
                () -> new TeamMemberException(ErrorCode.TEAM_MEMBER_NOT_FOUND));

        teamMemberRepository.deleteById(id);
    }

    public TeamMember updateTeamMember(UpdateTeamMemberDTO.Request request) {

        TeamMember teamMember = teamMemberRepository.findById(request.getId()).orElseThrow(
                () -> new TeamMemberException(ErrorCode.TEAM_MEMBER_NOT_FOUND));

        teamMember.setTeamRank(request.getTeamRank());

        return teamMemberRepository.save(teamMember);
    }


}
