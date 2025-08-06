package com.fantasyNFL.backend.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public List<Team> getTeamByConferenceAndDivision(String conference, String Division) {
        return teamRepository.findByConferenceAndDivision(conference, Division);
    }

    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> getTeamByConference(String conference) {
        return teamRepository.findByConference(conference);
    }

    public List<Team> getTeamByDivision(String division) {
        return teamRepository.findByDivision(division);
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeamsSortByWins() {
        List<Team> all = teamRepository.findAll();
        all.sort((team1, team2) -> team2.getWins() - team1.getWins());
        return all;
    }

    public List<Team> getTeamsWithWinsGreaterThan(int wins) {
        List<Team> all = teamRepository.findByWinsGreaterThan(wins);
        all.sort((team1, team2) -> team1.getLosses() - team2.getLosses());
        return all;
    }

    public Team updateTeam(String name, int wins, int losses, int ties) {
        Team team = teamRepository.findByName(name);
        if (team == null) {
            throw new RuntimeException("Team not found with name:" + name);
        }
        team.setWins(wins);
        team.setLosses(losses);
        team.setTies(ties);
        teamRepository.save(team);
        return team;
    }
    
    public void deleteTeamByName(String name) {
        Team team = teamRepository.findByName(name);
        if (team == null) {
            throw new RuntimeException("Team with name '" + name + "' not found.");
        }
        teamRepository.delete(team);
    }

}
