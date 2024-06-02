package com.example.GP.controller.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.dto.Gongjeong.Delete.DeleteDTO;
import com.example.GP.dto.Gongjeong.TeamMemberDTO;
import com.example.GP.service.Gongjeong.TeamMemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    @PostMapping("/teammember")
    public ResponseEntity<CreateTeamMemberDTO.Response> createTeamMember(
            @Valid @RequestBody CreateTeamMemberDTO.Request request) {

        return ResponseEntity.ok(CreateTeamMemberDTO.Response.from(
                teamMemberService.createTemMember(request)));
    }

    @GetMapping("/teammember")
    public ResponseEntity<TeamMemberDTO> getTeamMember(
            @RequestParam("teammemberId") Long id) {

        return ResponseEntity.ok(teamMemberService.getTeamMember(id));
    }

    @GetMapping("/teammembers")
    public ResponseEntity<List<TeamMember>> getAllTeamMember() {

        return ResponseEntity.ok(teamMemberService.getAllTeamMember());
    }

    @PostMapping("/teammember/delete")
    public ResponseEntity<DeleteDTO.Response> deleteTeamMember(
            @Valid @RequestBody DeleteDTO.Request request) {

        teamMemberService.deleteTeamMember(request.getId());

        return ResponseEntity.ok(DeleteDTO.Response.from());
    }


}
