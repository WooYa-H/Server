package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    boolean existsByTeamName(String name);
}
