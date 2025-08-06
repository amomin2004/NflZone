package com.fantasyNFL.backend.player;

import java.util.List;

import com.fantasyNFL.backend.team.Team;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @ManyToOne
    private Team team;
    private long rushingYards;
    private long receivingYards;
    private long sacks;
    private long tackles;
    private String position;
    private int touchdowns;
    private int fieldGoals;
    private int yearDrafted;
    private List<Long> fantasyPointsPerWeek;
    @Enumerated(EnumType.STRING)
    private PlayerType playerType; 

    public Player() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public long getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(long rushingYards) {
        this.rushingYards = rushingYards;
    }
    
    public long getReceivingYards() {
        return receivingYards;
    }

    public void setReceivingYards(long receivingYards) {
        this.receivingYards = receivingYards;
    }

    public long getSacks() {
        return sacks;
    }

    public void setSacks(long sacks) {
        this.sacks = sacks;
    } 

    public long getTackles() {
        return tackles;
    }

    public void setTackles(long tackles) {
        this.tackles = tackles;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(int touchdowns) {
        this.touchdowns = touchdowns;
    }
    
    public int getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(int fieldGoals) {
        this.fieldGoals = fieldGoals;
    }
    
    public int getYearDrafted() {
        return yearDrafted;
    }

    public void setYearDrafted(int yearDrafted) {
        this.yearDrafted = yearDrafted;
    }
    
    public List<Long> getFantasyPointsPerWeek() {
        return fantasyPointsPerWeek;
    }

    public void setFantasyPointsPerWeek(List<Long> fantasyPointsPerWeek) {
        this.fantasyPointsPerWeek = fantasyPointsPerWeek;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }


    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    @Override
    public String toString() {
        return "Player{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", team=" + (team != null ? team.getName() : "null") +
            ", rushingYards=" + rushingYards +
            ", receivingYards=" + receivingYards +
            ", sacks=" + sacks +
            ", tackles=" + tackles +
            ", position='" + position + '\'' +
            ", touchdowns=" + touchdowns +
            ", fieldGoals=" + fieldGoals +
            ", yearDrafted=" + yearDrafted +
            ", fantasyPointsPerWeek=" + fantasyPointsPerWeek +
            ", playerType=" + playerType +
            '}';
    }









    

}
