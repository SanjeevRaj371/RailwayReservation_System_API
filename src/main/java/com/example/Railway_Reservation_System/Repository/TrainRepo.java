package com.example.Railway_Reservation_System.Repository;

import com.example.Railway_Reservation_System.Model.TrainModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepo extends JpaRepository<TrainModel,Integer> {

    @Query("Select t FROM TrainModel t WHERE t.Starting = :s AND t.Ending = :e")
    TrainModel getTrainByRoute(String s, String e);
}
