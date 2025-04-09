package com.example.Railway_Reservation_System.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TrainModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int trainId;
    private String trainName;
    private String Starting;
    private String Ending;
    private int totalSeat;
    private int BookedSeat = 0;

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStarting() {
        return Starting;
    }

    public void setStarting(String starting) {
        Starting = starting;
    }

    public String getEnding() {
        return Ending;
    }

    public void setEnding(String ending) {
        Ending = ending;
    }

    public int getBookedSeat() {
        return BookedSeat;
    }

    public void setBookedSeat(int bookedSeat) {
        this.BookedSeat = bookedSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }
}
