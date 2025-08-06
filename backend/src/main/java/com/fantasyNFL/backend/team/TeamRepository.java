package com.fantasyNFL.backend.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findByConference(String conference);
    List<Team> findByDivision(String division);
    List<Team> findByConferenceAndDivision(String conference, String division);
    Team findByName(String name);
    Team findByAbbreviation(String abbreviation);
    List<Team> findByConferenceOrderByWinsDesc(String conference);
    List<Team> findByDivisionOrderByWinsDesc(String division);
    List<Team> findByWinsGreaterThan(int wins);
    List<Team> findByLossesLessThan(int losses);
    Optional<Team> findTopByConferenceOrderByWinsDesc(String conference);
    List<Team> findAll();

    
}

