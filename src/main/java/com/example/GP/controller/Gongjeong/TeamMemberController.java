package com.example.GP.controller.Gongjeong;

import com.example.GP.dto.Gongjeong.Create.CreateTeamMemberDTO;
import com.example.GP.dto.Gongjeong.TeamMemberDTO;
import com.example.GP.service.Gongjeong.TeamMemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
