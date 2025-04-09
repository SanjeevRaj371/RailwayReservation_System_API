package com.example.Railway_Reservation_System.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PassengerModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int passengerId;
    private String pName;
    private int pAge;
    private String pStarting;
    private String pEnding;


    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public String getpStarting() {
        return pStarting;
    }

    public void setpStarting(String pStarting) {
        this.pStarting = pStarting;
    }

    public String getpEnding() {
        return pEnding;
    }

    public void setpEnding(String pEnding) {
        this.pEnding = pEnding;
    }

}
