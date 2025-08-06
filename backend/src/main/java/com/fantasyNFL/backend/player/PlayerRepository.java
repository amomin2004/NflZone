package com.fantasyNFL.backend.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fantasyNFL.backend.team.Team;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByName(String name);
    List<Player> findByTeam(Team team);
    List<Player> findByPosition(String position);
    List<Player> findByRushingYardsGreaterThan(long rushingYards);
    List<Player> findByReceivingYardsGreaterThan(long receivingYards);
    List<Player> findByTeamAndPosition(Team team, String position);
    List<Player> findByTouchdownsGreaterThan(int touchdowns);
    List<Player> findByTeamAndPlayerType(Team team, PlayerType playerType);
    List<Player> findByPlayerType(PlayerType playerType);
    List<Player> findAll();
    Player findByNameAndTeam(String name, Team team);

}
