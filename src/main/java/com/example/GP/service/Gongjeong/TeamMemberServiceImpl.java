package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.repository.Gongjeong.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


}
