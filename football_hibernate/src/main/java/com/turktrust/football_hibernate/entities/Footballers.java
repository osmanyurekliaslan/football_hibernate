package com.turktrust.football_hibernate.entities;

import jakarta.persistence.*;



@Entity
@Table(name = "footballers")
public class Footballers extends BaseEntities {


    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "SURNAME", length = 100)
    private String surname;

    @Column(name = "AGE", length = 10)
    private int age;

    @Column(name = "PRICE", length = 50)
    private int price;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "TEAM_ID")
    private Teams team;

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public Footballers(String name, String surname, int age, int price, String country, Teams team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.price = price;
        this.country = country;
        this.team = team;
    }


    public Footballers() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Footballers{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", team=" + team +
                '}';
    }
}
