package com.fantasyNFL.backend.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasyNFL.backend.team.Team;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeam(Team team) {
        return playerRepository.findByTeam(team);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayerByNameAndTeam(String name, Team team) {
        Player player = playerRepository.findByNameAndTeam(name, team);
        if (player == null) {
            throw new RuntimeException("Player by the name of " + name + " does not exist.");
        }
        playerRepository.delete(player);
    }

    public List<Player> getPlayersWithTouchdownsGreaterThan(int touchdowns) {
        return playerRepository.findByTouchdownsGreaterThan(touchdowns);
    }

    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position);
    }

    public Player updatePlayerTeam(String name, Team currentTeam, Team newTeam) {
        Player player = playerRepository.findByNameAndTeam(name, currentTeam);
        if (player == null) {
            throw new RuntimeException("Player by the name of " + name + " does not exist");
        }
        player.setTeam(newTeam);
        playerRepository.save(player);
        return player;
    }


    public Player updatePlayerStats(String name, Team team, int touchdowns, long rushingYards, long receivingYards, long sacks, long tackles, int fieldGoals, List<Long> latestPoints) {
        Player player = playerRepository.findByNameAndTeam(name, team);
        if (player == null) {
            throw new RuntimeException("Player by the name of " + name + " does not exist");
        }

        player.getFantasyPointsPerWeek().addAll(latestPoints);
        player.setTouchdowns(touchdowns);

        String position = player.getPosition();

        if (position.equals("RB") || position.equals("WR") || position.equals("TE") || position.equals("QB")) {
            player.setReceivingYards(receivingYards);
            player.setRushingYards(rushingYards);
        }

        if (position.equals("LB") || position.equals("DE") || position.equals("CB") || position.equals("S")) {
            player.setSacks(sacks);
            player.setTackles(tackles);
        }

        if (position.equals("K")) {
            player.setFieldGoals(fieldGoals);
        }

        return playerRepository.save(player);
    }



}
