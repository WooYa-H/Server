package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.Create.CreateTeamDTO;
import com.example.GP.dto.Gongjeong.TeamDTO;
import com.example.GP.service.Gongjeong.TeamService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;


    @PostMapping("/team")
    public ResponseEntity<CreateTeamDTO.Response> createTeam(
            @Valid @RequestBody CreateTeamDTO.Request request) {

        return ResponseEntity.ok(CreateTeamDTO.Response.from(
                teamService.createTeam(request)));
    }

    @GetMapping("/team")
    public ResponseEntity<TeamDTO> getTeam(
            @RequestParam("teamId") Long id) {

        return ResponseEntity.ok(teamService.getTeam(id));
    }
}
