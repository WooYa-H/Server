package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.Create.CreateTeamDTO;
import com.example.GP.dto.Gongjeong.Delete.DeleteDTO;
import com.example.GP.dto.Gongjeong.TeamDTO;
import com.example.GP.dto.Gongjeong.TeamDTOS;
import com.example.GP.dto.Gongjeong.Update.UpdateTeamDTO;
import com.example.GP.service.Gongjeong.TeamService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<TeamDTOS> getTeam(
            @RequestParam("teamId") Long id) {

        return ResponseEntity.ok(teamService.getTeam(id));
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> getAllteams(){

        return ResponseEntity.ok(teamService.getAllTeam());
    }

    @PostMapping("/team/delete")
    public ResponseEntity<DeleteDTO.Response> deleteTeam(
            @Valid @RequestBody DeleteDTO.Request request) {

        teamService.deleteTeam(request.getId());

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }

    @PutMapping("/team")
    public ResponseEntity<UpdateTeamDTO.Response> updateTeam(
            @Valid @RequestBody UpdateTeamDTO.Request request) {

        return ResponseEntity.ok(UpdateTeamDTO.Response.from(
                teamService.updateTeam(request)));
    }
}
