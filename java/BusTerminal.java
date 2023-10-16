import java.time.LocalDateTime;
import java.util.*;

// Represents a bus terminal.
public class BusTerminal {
    private String name;
    private int numPlatforms;
    private List<Platform> platforms;

    public BusTerminal(String name, int numPlatforms) {
        this.name = name;
        this.numPlatforms = numPlatforms;
        this.platforms = new ArrayList<>();
        initializePlatforms();
    }

    // Initialize platforms in the bus terminal.
    private void initializePlatforms() {
        for (int i = 1; i <= numPlatforms; i++) {
            platforms.add(new Platform(i));
        }
    }

    // Run the simulation for a specified number of steps.
    public void runSimulation(int numSteps) {
        SimulationEngine simulationEngine = new SimulationEngine(this);
        for (int step = 1; step <= numSteps; step++) {
            System.out.println("Simulation Step " + step);
            simulationEngine.generatePassengerArrivals();
            simulationEngine.startBusDepartures();
            simulationEngine.updateTerminalState();
        }
    }

    // Getters for terminal information.
    public List<Platform> getPlatforms() {
        return platforms;
    }

    public String getName() {
        return name;
    }

    public int getNumPlatforms() {
        return numPlatforms;
    }

    public static void main(String[] args) {
        // Create a BusTerminal object with 3 platforms
        BusTerminal busTerminal = new BusTerminal("City Terminal", 3);

        // Specify the number of simulation steps
        int numSteps = 5;

        // Run the simulation for the specified number of steps
        busTerminal.runSimulation(numSteps);
    }
}

// Represents an individual platform at the bus terminal.
class Platform {
    private int platformID;
    private int capacity;
    private List<Passenger> passengers;

    public Platform(int platformID) {
        this.platformID = platformID;
        this.capacity = 50; // Default capacity of 50 passengers per platform
        this.passengers = new ArrayList<>();
    }

    // Board a passenger onto the platform.
    public void boardPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Depart a bus from the platform.
    public void departBus() {
        passengers.clear();
    }

    // Getters for platform information.
    public int getPlatformID() {
        return platformID;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}

// Represents a passenger with a unique ID and destination.
class Passenger {
    private int passengerID;
    private String destination;

    public Passenger(int passengerID, String destination) {
        this.passengerID = passengerID;
        this.destination = destination;
    }

    // Getters for passenger information.
    public int getPassengerID() {
        return passengerID;
    }

    public String getDestination() {
        return destination;
    }
}

// Represents the schedule of bus departures.
class Schedule {
    private Map<String, LocalDateTime> departureTimes;

    public Schedule() {
        this.departureTimes = new HashMap<>();
    }

    // Add a departure entry to the schedule.
    public void addEntry(String destination, LocalDateTime time) {
        departureTimes.put(destination, time);
    }

    // Get the departure time for a destination.
    public LocalDateTime getDepartureTime(String destination) {
        return departureTimes.get(destination);
    }

    // Get the set of destinations in the schedule.
    public Set<String> getDestinations() {
        return departureTimes.keySet();
    }
}

// Represents the simulation engine for the bus terminal.
class SimulationEngine {
    private BusTerminal terminal;
    private Schedule schedule;

    public SimulationEngine(BusTerminal terminal) {
        this.terminal = terminal;
        this.schedule = new Schedule();
        initializeSchedule();
    }

    // Initialize the schedule with departure entries.
    private void initializeSchedule() {
        schedule.addEntry("Destination A", LocalDateTime.of(2023, 10, 10, 8, 0));
        schedule.addEntry("Destination B", LocalDateTime.of(2023, 10, 10, 9, 30));
        schedule.addEntry("Destination C", LocalDateTime.of(2023, 10, 10, 11, 0));
    }

    // Simulate the generation of passenger arrivals.
    public void generatePassengerArrivals() {
        List<Platform> platforms = terminal.getPlatforms();
        Random random = new Random();

        for (Platform platform : platforms) {
            int numPassengers = random.nextInt(platform.getCapacity() + 1);
            for (int i = 0; i < numPassengers; i++) {
                String destination = getRandomDestination();
                Passenger passenger = new Passenger(i + 1, destination);
                platform.boardPassenger(passenger);
            }
        }
    }

    // Simulate the departure of buses from platforms.
    public void startBusDepartures() {
        List<Platform> platforms = terminal.getPlatforms();

        for (Platform platform : platforms) {
            if (!platform.getPassengers().isEmpty()) {
                String destination = platform.getPassengers().get(0).getDestination();
                LocalDateTime departureTime = schedule.getDepartureTime(destination);

                if (departureTime.isBefore(LocalDateTime.now())) {
                    Bus bus = new Bus(generateBusNumber(), departureTime);
                    bus.depart();
                    platform.departBus();
                }
            }
        }
    }

    // Placeholder for updating the terminal state.
    public void updateTerminalState() {
        // Implement logic to update the state of the terminal (e.g., track statistics).
    }

    // Generate a random destination from the schedule.
    private String getRandomDestination() {
        Set<String> destinations = schedule.getDestinations();
        Random random = new Random();
        int randomIndex = random.nextInt(destinations.size());
        return destinations.stream().skip(randomIndex).findFirst().orElse("");
    }

    // Generate a random three-digit bus number.
    private int generateBusNumber() {
        Random random = new Random();
        return 100 + random.nextInt(900);
    }
}

// Represents a bus with a unique number and departure time.
class Bus {
    private int busNumber;
    private LocalDateTime departureTime;

    public Bus(int busNumber, LocalDateTime departureTime) {
        this.busNumber = busNumber;
        this.departureTime = departureTime;
    }

    // Simulate the departure of a bus.
    public void depart() {
        System.out.println("Bus " + busNumber + " departed at " + departureTime);
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}