package com.fantasyNFL.backend.team;

import jakarta.persistence.*;
import java.util.*;

@Entity // this is a database table
@Table(name="teams") 
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Will auto generate ID #s for teams
    private int id;

    private String name;
    private String city;
    private String conference;
    private String division;
    private String abbreviation; 
    private int wins;
    private int losses;
    private int ties;
    private int conferenceRank;
    private int divisionRank;
    private String headCoach;
    private String generalManager;
    private String stadiumName;

    //@OneToMany
    //private List<Player> players;

    // Constructor
    public Team() {

    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getConferenceRank() {
        return conferenceRank;
    }

    public void setConferenceRank(int conferenceRank) {
        this.conferenceRank = conferenceRank;
    }
    
    public int getDivisionRank() {
        return divisionRank;
    }

    public void setDivisionRank(int divisionRank) {
        this.divisionRank = divisionRank;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
    }
    
    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", conference='" + conference + '\'' +
                ", division='" + division + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", ties=" + ties +
                ", conferenceRank=" + conferenceRank +
                ", divisionRank=" + divisionRank +
                ", headCoach='" + headCoach + '\'' +
                ", generalManager='" + generalManager + '\'' +
                ", stadiumName='" + stadiumName + '\'' +
                '}';
    }

}