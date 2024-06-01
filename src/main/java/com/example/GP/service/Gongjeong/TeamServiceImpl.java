package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import com.example.GP.dto.Gongjeong.Create.CreateTeamDTO;
import com.example.GP.exception.Gonjeong.TeamException;
import com.example.GP.repository.Gongjeong.TeamRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {


    private final TeamRepository teamRepository;


    public Team createTeam(CreateTeamDTO.Request request) {
        if (teamRepository.existsByTeamName(request.getTeamName())) {
            throw new TeamException(ErrorCode.TEAM_NAME_DUPLICATED);
        }

        return teamRepository.save(Team.builder()
                .teamName(request.getTeamName())
                .leader(request.getLeader())
                .build());
    }
}
