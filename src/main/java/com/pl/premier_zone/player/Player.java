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

    private String position;

    private Integer age;

    private Integer matches_played;

    private Integer starts;


    private Double goals;

    private Double assists;

    private Double penalties_scored;

    private Double yellow_cards;

    private Double red_cards;

    private Double expected_goals;

    private Double expected_assists;

    private String team_name;



}
