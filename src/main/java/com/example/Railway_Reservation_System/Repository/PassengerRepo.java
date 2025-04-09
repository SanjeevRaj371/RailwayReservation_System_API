package com.example.Railway_Reservation_System.Repository;

import com.example.Railway_Reservation_System.Model.PassengerModel;
import com.example.Railway_Reservation_System.Model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<PassengerModel,Integer> {


}
