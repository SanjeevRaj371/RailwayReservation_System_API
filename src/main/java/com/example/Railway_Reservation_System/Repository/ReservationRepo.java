package com.example.Railway_Reservation_System.Repository;

import com.example.Railway_Reservation_System.Model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReservationRepo extends JpaRepository<ReservationModel,Integer> {

    @Query("SELECT r FROM ReservationModel r where r.passengerModel.passengerId=:pId")
    ReservationModel getReservationByPassenger(int pId);

    @Query("SELECT r FROM ReservationModel r where r.trainModel.trainId=:trainId")
    List<ReservationModel> getReservationByTrain(int trainId);
}
