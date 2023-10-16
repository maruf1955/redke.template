import java.time.LocalDateTime;
import java.util.*;

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

    private void initializePlatforms() {
        for (int i = 1; i <= numPlatforms; i++) {
            platforms.add(new Platform(i));
        }
    }

    public void runSimulation() {
        // Implement the simulation logic here
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public String getName() {
        return name;
    }

    public int getNumPlatforms() {
        return numPlatforms;
    }
}

class Platform {
    private int platformID;
    private int capacity;
    private List<Passenger> passengers;

    public Platform(int platformID) {
        this.platformID = platformID;
        this.capacity = 50; // Assuming a default capacity of 50 passengers per platform
        this.passengers = new ArrayList<>();
    }

    public void boardPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void departBus() {
        passengers.clear();
    }

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

class Passenger {
    private int passengerID;
    private String destination;

    public Passenger(int passengerID, String destination) {
        this.passengerID = passengerID;
        this.destination = destination;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public String getDestination() {
        return destination;
    }
}

class Schedule {
    private Map<String, LocalDateTime> departureTimes;

    public Schedule() {
        this.departureTimes = new HashMap<>();
    }

    public void addEntry(String destination, LocalDateTime time) {
        departureTimes.put(destination, time);
    }

    public LocalDateTime getDepartureTime(String destination) {
        return departureTimes.get(destination);
    }

    public Set<String> getDestinations() {
        return departureTimes.keySet();
    }
}

class SimulationEngine {
    private BusTerminal terminal;
    private Schedule schedule;

    public SimulationEngine(BusTerminal terminal, Schedule schedule) {
        this.terminal = terminal;
        this.schedule = schedule;
    }

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

    public void updateTerminalState() {
        // Implement logic to update the state of the terminal
    }

    private String getRandomDestination() {
        Set<String> destinations = schedule.getDestinations();
        Random random = new Random();
        int randomIndex = random.nextInt(destinations.size());
        return destinations.stream().skip(randomIndex).findFirst().orElse("");
    }

    private int generateBusNumber() {
        Random random = new Random();
        return 100 + random.nextInt(900); // Generate a three-digit bus number
    }
}

class Bus {
    private int busNumber;
    private LocalDateTime departureTime;

    public Bus(int busNumber, LocalDateTime departureTime) {
        this.busNumber = busNumber;
        this.departureTime = departureTime;
    }

    public void depart() {
        // Implement bus departure logic here
    }

    public int getBusNumber() {
        return busNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a BusTerminal object with 3 platforms
        BusTerminal busTerminal = new BusTerminal("City Terminal", 3);

        // Create a Schedule object and add departure entries
        Schedule schedule = new Schedule();
        schedule.addEntry("Destination A", LocalDateTime.of(2023, 10, 10, 8, 0));
        schedule.addEntry("Destination B", LocalDateTime.of(2023, 10, 10, 9, 30));
        schedule.addEntry("Destination C", LocalDateTime.of(2023, 10, 10, 11, 0));

        // Create a SimulationEngine and provide the BusTerminal and Schedule
        SimulationEngine simulationEngine = new SimulationEngine(busTerminal, schedule);

        // Simulate passenger arrivals and bus departures
        simulationEngine.generatePassengerArrivals();
        simulationEngine.startBusDepartures();
        simulationEngine.updateTerminalState();

        // Print simulation results or perform additional actions as needed
        printSimulationResults(busTerminal);
    }

    private static void printSimulationResults(BusTerminal busTerminal) {
        System.out.println("Simulation Results:");
        System.out.println("Bus Terminal Name: " + busTerminal.getName());
        System.out.println("Number of Platforms: " + busTerminal.getNumPlatforms());

        List<Platform> platforms = busTerminal.getPlatforms();
        for (Platform platform : platforms) {
            System.out
