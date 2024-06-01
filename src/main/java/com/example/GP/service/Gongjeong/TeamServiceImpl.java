package com.example.GP.service.Gongjeong;

import com.example.GP.repository.Gongjeong.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {


    private final TeamRepository teamRepository;


}
