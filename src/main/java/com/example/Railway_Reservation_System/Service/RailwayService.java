package com.example.Railway_Reservation_System.Service;

import com.example.Railway_Reservation_System.Model.PassengerModel;
import com.example.Railway_Reservation_System.Model.ReservationModel;
import com.example.Railway_Reservation_System.Model.TrainModel;
import com.example.Railway_Reservation_System.Repository.PassengerRepo;
import com.example.Railway_Reservation_System.Repository.ReservationRepo;
import com.example.Railway_Reservation_System.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RailwayService {
    @Autowired
    TrainRepo trainRepo;
    @Autowired
    PassengerRepo passengerRepo;
    @Autowired
    ReservationRepo reservationRepo;

    public TrainModel createTrain(TrainModel trainModel) {
        return trainRepo.save(trainModel);
    }

    public List<TrainModel> createTrain(List<TrainModel> trainModels) {
        return trainRepo.saveAll(trainModels);
    }

    public List<TrainModel> getAllTrain() {
        return trainRepo.findAll();
    }

    public TrainModel getTrainById(int id) {
        return trainRepo.findById(id).orElse(null);
    }

    public TrainModel getTrainByRoute(String s, String e) {
        return trainRepo.getTrainByRoute(s,e);
    }

    public String deleteTrainById(int trainId) {
        TrainModel t=trainRepo.findById(trainId).orElse(null);
        if(t==null){
            return "Train_Id Doesn't Exist";
        }
        else{
            trainRepo.delete(t);
            return  "Train_Id: "+trainId+" Deleted SuccessFully";
        }
    }

    public String deleteAllTrain() {
        trainRepo.deleteAll();
        return "All Train are Delete";
    }

    public String updateTrainDetails(int trainId, TrainModel trainModel) {
        TrainModel t=trainRepo.findById(trainId).orElse(null);
        if(t==null){
            return "Train_Id Doesn't Exist";
        }
        else{
            t.setTrainName(trainModel.getTrainName());
            t.setStarting(trainModel.getStarting());
            t.setEnding(trainModel.getEnding());
            t.setTotalSeat(trainModel.getTotalSeat());
            trainRepo.save(t);
            return  "Train_Id: "+trainId+" Updated SuccessFully";
        }
    }

    public PassengerModel createPassenger(PassengerModel passengerModel) {
        return passengerRepo.save(passengerModel);
    }

    public List<PassengerModel> createPassenger(List<PassengerModel> passengerModels) {
        return passengerRepo.saveAll(passengerModels);
    }

    public List<PassengerModel> getAllPassengers() {
        return passengerRepo.findAll();
    }

    public PassengerModel getPassenger(int id) {
        return passengerRepo.findById(id).orElse(null);
    }

    public String updatePassenger(int pId, PassengerModel passengerModel) {
        PassengerModel p = passengerRepo.findById(pId).orElse(null);
        p.setpName(passengerModel.getpName());
        p.setpAge(passengerModel.getpAge());
        p.setpStarting(passengerModel.getpStarting());
        p.setpEnding(passengerModel.getpEnding());
        passengerRepo.save(p);

        return "Passenger Id: "+pId+" is updated successfully";
    }

    public String createReservation(int pId) {
        PassengerModel p = passengerRepo.findById(pId).orElse(null);
        if(p==null){
            return "Passenger id is wrong check the passenger id";
        }
        TrainModel t=getTrainByRoute(p.getpStarting(),p.getpEnding());
        if(t.getBookedSeat()<t.getTotalSeat()){
            t.setBookedSeat(t.getBookedSeat()+1);
            trainRepo.save(t);
            ReservationModel r= new ReservationModel();
            r.setReservationStatus("Reserved");
            r.setPassengerModel(p);
            r.setTrainModel(t);
            r.setTime(LocalDateTime.now());
            reservationRepo.save(r);
            return "Reservation Created for Passenger Id: "+pId+"as"+r.getReservationStatus();
        }
        ReservationModel r =new ReservationModel();
        trainRepo.save(t);
        r.setReservationStatus("Waiting_List");
        r.setPassengerModel(p);
        r.setTrainModel(t);
        r.setTime(LocalDateTime.now());
        reservationRepo.save(r);
        return "Reservation Created for Passenger Id: "+pId+"as"+r.getReservationStatus();
    }

    public List<ReservationModel> getAllReservation() {
        return reservationRepo.findAll();
    }

    public ReservationModel getReservationByPassenger(int pId) {
        PassengerModel p = passengerRepo.findById(pId).orElse(null);
        if(p==null){
            return null;
        }
        return reservationRepo.getReservationByPassenger(pId);
    }

    public List<ReservationModel> getReservationByTrain(int trainId) {
        TrainModel t = trainRepo.findById(trainId).orElse(null);
        if(t==null){
            return null;
        }
        return reservationRepo.getReservationByTrain(trainId);
    }

    public String getReservationStatus(int rId) {
        ReservationModel r = reservationRepo.findById(rId).orElse(null);
        if(r==null){
            return "Reservation ID is Wrong";
        }
        return "Reservation Status of ID "+rId+" is "+r.getReservationStatus();
    }

    public String getSeatAvailability(int tId) {
        TrainModel t = trainRepo.findById(tId).orElse(null);
        if(t==null){
            return "Train Id is Wrong";
        }
        int seat =t.getTotalSeat() - t.getBookedSeat();
        return "The Availability of TrainID "+tId+" is "+seat;
    }

    public String cancelReservation(int rId) {
        ReservationModel r = reservationRepo.findById(rId).orElse(null);
        if(r==null){
            return "Reservation id is Wrong";
        }
        reservationRepo.delete(r);
        return "Reservation Id "+rId+" is Cancel Successfully";
    }
}
