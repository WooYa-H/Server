package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import com.example.GP.dto.Gongjeong.Create.CreateTeamDTO;
import com.example.GP.dto.Gongjeong.TeamDTO;

public interface TeamService {

    Team createTeam(CreateTeamDTO.Request request);

    TeamDTO getTeam(Long id);
}
