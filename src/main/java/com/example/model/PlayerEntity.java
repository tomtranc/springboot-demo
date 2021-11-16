package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table
public class PlayerEntity {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Id
    @Column(nullable = false, updatable = false)
    @NotEmpty
    @Pattern(regexp = "^\\w+$")
    private String playerId;

    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;

    // deaths
    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;

    // player stats
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private String bats;
    @Column(name="throws")
    @JsonProperty("throws")
    private String throwsHand;
    private LocalDate debut;
    private LocalDate finalGame;
    private String retroID;
    private String bbrefID;

    @CreationTimestamp
    private LocalDateTime createdTs;

    @UpdateTimestamp
    private LocalDateTime updatedTs;

    public PlayerEntity() {

    }
    public PlayerEntity(String[] playerData) {
        // this is a bit loose as if our input size changes, this parsing will break
        this.playerId = playerData[0];
        this.birthYear = !StringUtils.isEmpty(playerData[1]) ? Integer.parseInt(playerData[1]) : null;
        this.birthMonth = !StringUtils.isEmpty(playerData[2]) ? Integer.parseInt(playerData[2]) : null;
        this.birthDay = !StringUtils.isEmpty(playerData[3]) ? Integer.parseInt(playerData[3]) : null;
        this.birthCountry = playerData[4];
        this.birthState = playerData[5];
        this.birthCity = playerData[6];
        this.deathYear = !StringUtils.isEmpty(playerData[7]) ? Integer.parseInt(playerData[7]) : null;
        this.deathMonth = !StringUtils.isEmpty(playerData[8]) ? Integer.parseInt(playerData[8]) : null;
        this.deathDay = !StringUtils.isEmpty(playerData[9]) ? Integer.parseInt(playerData[9]) : null;
        this.deathCountry = !StringUtils.isEmpty(playerData[10]) ? playerData[10] : null;
        this.deathState = !StringUtils.isEmpty(playerData[11]) ? playerData[11] : null;
        this.deathCity = !StringUtils.isEmpty(playerData[12]) ? playerData[12] : null;
        this.nameFirst = playerData[13];
        this.nameLast = playerData[14];
        this.nameGiven = playerData[15];
        this.weight = !StringUtils.isEmpty(playerData[16]) ? Integer.parseInt(playerData[16]) : null;
        this.height = !StringUtils.isEmpty(playerData[17]) ? Integer.parseInt(playerData[17]) : null;
        this.bats = playerData[18];
        this.throwsHand = playerData[19];
        this.debut = !StringUtils.isEmpty(playerData[20]) ? LocalDate.parse(playerData[20], formatter) : null;
        this.finalGame = !StringUtils.isEmpty(playerData[21]) ? LocalDate.parse(playerData[20], formatter) : null;
        this.retroID = playerData[22];
        this.bbrefID = playerData[23];
    }
}
