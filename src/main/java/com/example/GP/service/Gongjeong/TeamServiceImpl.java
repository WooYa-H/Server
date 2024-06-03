package com.example.GP.service.Gongjeong;

import com.example.GP.domain.Gongjeong.Business;
import com.example.GP.domain.Gongjeong.Team;
import com.example.GP.dto.Gongjeong.Create.CreateTeamDTO;
import com.example.GP.dto.Gongjeong.TeamDTO;
import com.example.GP.dto.Gongjeong.Update.UpdateTeamDTO;
import com.example.GP.exception.Gonjeong.BusinessException;
import com.example.GP.exception.Gonjeong.TeamException;
import com.example.GP.repository.Gongjeong.BusinessRepository;
import com.example.GP.repository.Gongjeong.TeamRepository;
import com.example.GP.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {


    private final TeamRepository teamRepository;
    private final BusinessRepository businessRepository;


    public Team createTeam(CreateTeamDTO.Request request) {
        if (teamRepository.existsByTeamName(request.getTeamName())) {
            throw new TeamException(ErrorCode.TEAM_NAME_DUPLICATED);
        }

        return teamRepository.save(Team.builder()
                .teamName(request.getTeamName())
                .leader(request.getLeader())
                .build());
    }

    public TeamDTO getTeam(Long id) {

        Team team = teamRepository.findById(id).orElseThrow(
                () -> new TeamException(ErrorCode.TEAM_NOT_FOUND));

        return new TeamDTO(team);
    }

    public List<TeamDTO> getAllTeam() {

        List<Team> teamList = teamRepository.findAll();

        return teamList.stream()
                .map(TeamDTO::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void deleteTeam(Long id) {

        teamRepository.deleteById(id);
    }

    public Team updateTeam(UpdateTeamDTO.Request request) {

        Team team = teamRepository.findById(request.getId()).orElseThrow(
                () -> new TeamException(ErrorCode.TEAM_NOT_FOUND));

        Business business = businessRepository.findById(request.getBusinessId()).orElseThrow(
                () -> new BusinessException(ErrorCode.BUSINESS_NOT_FOUND));

        team.setTeamName(request.getTeamName());
        team.setBusiness(business);
        team.setLeader(request.getLeader());

        return teamRepository.save(team);
    }
}
