package com.pl.premier_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_data")
public class Player {
    @Id
    @Column(name="player_name",unique=true,nullable=false)
    private String name;

    @Column(name="nation")
    private String nation;




    @Column(name="position")
    private String position;

    @Column(name="age")
    private Integer age;

    @Column(name="matches_played")
    private Integer matches_played;

    @Column(name="starts")
    private Integer starts;


    @Column(name="goals")
    private Double goals;

    @Column(name="assists")
    private Double assists;

    @Column(name="penalties_scored")
    private Double penalties_scored;

    @Column(name="yellow_cards")
    private Double yellow_cards;

    @Column(name="red_cards")
    private Double red_cards;

    @Column(name="expected_goals")
    private Double expected_goals;

    @Column(name="expected_assists")
    private Double expected_assists;

    @Column(name="team_name")
    private String team_name;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, String nation, String position, Integer age, Integer matches_played, Integer starts, Double goals, Double assists, Double penalties_scored, Double yellow_cards, Double red_cards, Double expected_goals, Double expected_assists, String team_name) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.matches_played = matches_played;
        this.starts = starts;
        this.goals = goals;
        this.assists = assists;
        this.penalties_scored = penalties_scored;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.expected_goals = expected_goals;
        this.expected_assists = expected_assists;
        this.team_name = team_name;
    }


    public Double getExpected_assists() {
        return expected_assists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getExpected_goals() {
        return expected_goals;
    }

    public Double getRed_cards() {
        return red_cards;
    }

    public Double getYellow_cards() {
        return yellow_cards;
    }

    public Double getAssists() {
        return assists;
    }

    public Double getPenalties_scored() {
        return penalties_scored;
    }

    public Double getGoals() {
        return goals;
    }

    public Integer getStarts() {
        return starts;
    }

    public Integer getMatches_played() {
        return matches_played;
    }

    public String getPosition() {
        return position;
    }

    public String getNation() {
        return nation;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getTeam_name() {
        return team_name;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMatches_played(Integer matches_played) {
        this.matches_played = matches_played;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public void setPenalties_scored(Double penalties_scored) {
        this.penalties_scored = penalties_scored;
    }

    public void setYellow_cards(Double yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public void setRed_cards(Double red_cards) {
        this.red_cards = red_cards;
    }

    public void setExpected_goals(Double expected_goals) {
        this.expected_goals = expected_goals;
    }

    public void setExpected_assists(Double expected_assists) {
        this.expected_assists = expected_assists;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

}
