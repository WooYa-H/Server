package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    boolean existsByTeamIdAndEmployeeNumber(Long teamId, String employeeNumber);

    @Query("SELECT tb FROM TeamMember tb WHERE tb.team.id IN :teamIds")
    List<TeamMember> findAllByTeamIdIn(@Param("teamIds") List<Long> teamIds);
}
