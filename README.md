# RailwayReservation_System_API
The REST APIs manage a railway reservation system, offering endpoints to create, read, update, and delete trains, passengers, and reservations. Additional functionalities include checking seat availability, retrieving reservation status, and filtering data by route, train ID, or passenger ID for efficient management and tracking.

🚆 Train APIs
@PostMapping("/CreateTrain")
Creates a new train entry with details like train name, number, route, etc.

@PostMapping("/CreateMultipleTrains")
Accepts a list of trains and creates multiple train records in a single request.

@GetMapping("/ListAllTrains")
Retrieves a list of all trains available in the system.

@GetMapping("/getTrainById/{id}")
Fetches train details by its unique ID.

@GetMapping("/getTrainByRoute")
Returns trains that operate on a specific route or match a given route query.

@DeleteMapping("/deleteTrainById/{trainId}")
Deletes a single train using its unique train ID.

@DeleteMapping("/deleteAllTrain")
Removes all train entries from the system.

@PostMapping("/updateTrainDetails/{trainId}")
Updates existing details of a specific train identified by its ID.

👤 Passenger APIs
@PostMapping("/createPassenger")
Adds a new passenger with personal and contact information.

@PostMapping("/createPassengers")
Allows bulk creation of passenger records.

@GetMapping("/getAllPassengers")
Retrieves a list of all passengers registered in the system.

@GetMapping("/getPassenger/{PassengerId}")
Returns details of a specific passenger using their ID.

@PostMapping("/updatePassenger/{pId}")
Updates the personal or contact details of an existing passenger.

📅 Reservation APIs
@PostMapping("/createReservation/{pId}")
Creates a reservation for a given passenger, linking it to a specific train and seat.

@GetMapping("/getAllReservation")
Fetches all reservation records across trains and passengers.

@GetMapping("/getReservationByPassenger/{pId}")
Retrieves all reservations associated with a specific passenger.

@GetMapping("/getReservationByTrain/{trainId}")
Lists all reservations made for a specific train.

@GetMapping("/getReservationStatus/{rId}")
Returns the status (e.g., confirmed, waitlisted, canceled) of a reservation by ID.

@GetMapping("/getSeatAvailability/{tId}")
Checks how many seats are available on a particular train.

@GetMapping("/cancelReservation/{rId}")
Cancels an existing reservation using its reservation ID. (Consider @DeleteMapping or @PutMapping for better REST practices.)
