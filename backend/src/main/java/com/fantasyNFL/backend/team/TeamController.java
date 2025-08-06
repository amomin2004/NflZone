package com.fantasyNFL.backend.team;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/name/{name}")
    public Team getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }

    @GetMapping("/division/{divison}")
    public List<Team> getTeamByDivision(@PathVariable String division) {
        return teamService.getTeamByDivision(division);
    }

    @PostMapping
    public Team addTeam(Team team) {
        return teamService.addTeam(team);
    }

    @PutMapping("/update")
    public Team updateTeamRecord(@RequestParam String name, @RequestParam int wins, @RequestParam int losses, @RequestParam int ties) {
        return teamService.updateTeam(name, wins, losses, ties);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteTeamByName(@PathVariable String name) {
        Team team = teamService.getTeamByName(name);
        if (team == null ) {
            throw new RuntimeException("Team with name " + name + " does not exist." );
        }
        teamService.deleteTeamByName(name);
    }

    @GetMapping("/sorted-by-wins")
    public List<Team> getTeamsSortedByWins() {
        return teamService.getAllTeamsSortByWins();
    }

    @GetMapping("/wins")
    public List<Team> getTeamsWithWinsGreaterThan(@RequestParam int wins) {
        return teamService.getTeamsWithWinsGreaterThan(wins);
    }

}
