package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import com.example.GP.dto.Gongjeong.Create.CreateTeamDTO;
import com.example.GP.dto.Gongjeong.TeamDTO;
import com.example.GP.dto.Gongjeong.TeamDTOS;
import com.example.GP.dto.Gongjeong.Update.UpdateTeamDTO;

import java.util.List;

public interface TeamService {

    Team createTeam(CreateTeamDTO.Request request);

    TeamDTOS getTeam(Long id);

    List<TeamDTO> getAllTeam();

    void deleteTeam(Long id);

    Team updateTeam(UpdateTeamDTO.Request request);
}
