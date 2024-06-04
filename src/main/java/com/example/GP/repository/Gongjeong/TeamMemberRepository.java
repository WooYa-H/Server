package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    boolean existsByTeamIdAndEmployeeNumber(Long teamId, String employeeNumber);
}
