package com.turktrust.football_hibernate.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "team_history")
public class TeamHistory extends BaseEntities {

    @Column(name = "JOIN_DATE", length = 100)
    private LocalDate joinDate;

    @Column(name = "LEAVE_DATE", length = 100)
    private LocalDate leaveDate;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "TEAM_ID")
    private Teams team;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "FOOTBALLER_ID")
    private Footballers footballer;


    public TeamHistory(LocalDate joinDate, LocalDate leaveDate, Teams team, Footballers footballer) {

        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
        this.team = team;
        this.footballer = footballer;
    }

    public TeamHistory() {
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public Footballers getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballers footballer) {
        this.footballer = footballer;
    }

    @Override
    public String toString() {
        return "TeamHistory{" +
                "joinDate=" + joinDate +
                ", leaveDate=" + leaveDate +
                ", team=" + team +
                ", footballer=" + footballer +
                '}';
    }
}
