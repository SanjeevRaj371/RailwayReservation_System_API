package com.example.Railway_Reservation_System.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ReservationModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int rId;
    private String reservationStatus;
    @ManyToOne
    @JoinColumn(name = "Passenger_id")
    PassengerModel passengerModel;
    @ManyToOne
    @JoinColumn(name = "train_Id")
    TrainModel trainModel;
    private LocalDateTime time;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public PassengerModel getPassengerModel() {
        return passengerModel;
    }

    public void setPassengerModel(PassengerModel passengerModel) {
        this.passengerModel = passengerModel;
    }

    public TrainModel getTrainModel() {
        return trainModel;
    }

    public void setTrainModel(TrainModel trainModel) {
        this.trainModel = trainModel;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
