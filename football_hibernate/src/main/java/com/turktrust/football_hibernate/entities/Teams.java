package com.turktrust.football_hibernate.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "teams", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "country"}))
public class Teams extends BaseEntities {

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "SHORT_NAME", length = 10)
    private String shortname;

    @Column(name = "COUNTRY", length = 50)
    private String country;


    public Teams(String name, String shortname, String country) {
//        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.country = country;
    }

    public Teams() {
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "Name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
