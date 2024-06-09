package com.example.GP.repository.Gongjeong;

import com.example.GP.domain.Gongjeong.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    boolean existsByTeamName(String name);

    List<Team> findByBusinessId(Long businessId);

    @Query("SELECT t FROM Team t WHERE t.business.id IN :businessIds")
    List<Team> findAllByBusinessIdIn(@Param("businessIds") List<Long> businessIds);
}
