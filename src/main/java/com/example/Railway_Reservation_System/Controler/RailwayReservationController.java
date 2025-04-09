package com.example.Railway_Reservation_System.Controler;

import com.example.Railway_Reservation_System.Model.PassengerModel;
import com.example.Railway_Reservation_System.Model.ReservationModel;
import com.example.Railway_Reservation_System.Model.TrainModel;
import com.example.Railway_Reservation_System.Repository.TrainRepo;
import com.example.Railway_Reservation_System.Service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/RailwayReservation")
@RestController
public class RailwayReservationController {
    @Autowired
    TrainRepo trainRepo;
    @Autowired
    RailwayService railwayService;

    @PostMapping("/CreateTrain")
    public TrainModel createTrain(@RequestBody TrainModel trainModel){
        return railwayService.createTrain(trainModel);

    }

    @PostMapping("/CreateMultipleTrains")
    public List<TrainModel> createTrains(@RequestBody List<TrainModel> trainModels){
        return railwayService.createTrain(trainModels);
    }

    @GetMapping("/ListAllTrains")
    public List<TrainModel> getAllTrain(){
        return railwayService.getAllTrain();
    }

    @GetMapping("/getTrainById/{id}")
    public TrainModel getTrainById(@PathVariable int id){
        return railwayService.getTrainById(id);
    }

    @GetMapping("/getTrainByRoute")
    public TrainModel getTrainByRoute(@RequestParam("Starting") String s,@RequestParam("Ending") String e){
        return railwayService.getTrainByRoute(s,e);
    }

    @DeleteMapping("/deleteTrainById/{trainId}")
    public String deleteTrainById(@PathVariable int trainId){
        return railwayService.deleteTrainById(trainId);
    }

    @DeleteMapping("/deleteAllTrain")
    public String deleteAllTrain(){
        return railwayService.deleteAllTrain();
    }

    @PostMapping("/updateTrainDetails/{trainId}")
    public String updateTrainDetails(@PathVariable int trainId,@RequestBody TrainModel trainModel){
        return railwayService.updateTrainDetails(trainId,trainModel);
    }

    @PostMapping("/createPassenger")
    public PassengerModel createPassenger(@RequestBody PassengerModel passengerModel){
        return railwayService.createPassenger(passengerModel);
    }

    @PostMapping("/createPassengers")
    public List<PassengerModel> createPassenger(@RequestBody List<PassengerModel> passengerModels){
        return railwayService.createPassenger(passengerModels);
    }

    @GetMapping("/getAllPassengers")
    public List<PassengerModel> getAllPassengers(){
        return railwayService.getAllPassengers();
    }

    @GetMapping("/getPassenger/{PassengerId}")
    public PassengerModel getPassenger(@PathVariable int PassengerId){
        return railwayService.getPassenger(PassengerId);
    }

    @PostMapping("/updatePassenger/{pId}")
    public String updatePassenger(@PathVariable int pId,@RequestBody PassengerModel passengerModel){
        return railwayService.updatePassenger(pId,passengerModel);
    }

    @PostMapping("/createReservation/{pId}")
    public String createReservation(@PathVariable int pId){
        return railwayService.createReservation(pId);
    }

    @GetMapping("/getAllReservation")
    public List<ReservationModel>getAllReservation(){
        return railwayService.getAllReservation();
    }

    @GetMapping("/getReservationByPassenger/{pId}")
    public ReservationModel getReservationByPassenger(@PathVariable int pId){
        return railwayService.getReservationByPassenger(pId);
    }

    @GetMapping("/getReservationByTrain/{trainId}")
    public List<ReservationModel> getReservationByTrain(@PathVariable int trainId){
        return railwayService.getReservationByTrain(trainId);
    }

    @GetMapping("/getReservationStatus/{rId}")
    public String getReservationStatus(@PathVariable int rId){
        return railwayService.getReservationStatus(rId);
    }

    @GetMapping("/getSeatAvailability/{tId}")
    public String getSeatAvailability(@PathVariable int tId){
        return railwayService.getSeatAvailability(tId);
    }

    @GetMapping("/cancelReservation/{rId}")
    public String cancelReservation(@PathVariable int rId){
        return railwayService.cancelReservation(rId);
    }


}
