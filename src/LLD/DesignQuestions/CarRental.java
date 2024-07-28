package LLD.DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum VehicleStatus {
    BOOKED,
    IN_SERVICE,
    AVAILABLE
}
class RentalVehicle {
    String registrationNumber;
    String company;
    String model;
    String kmDriven;
    VehicleStatus vehicleStatus;
    int pricePerHour;

    public RentalVehicle(String registrationNumber, String company, String model, String kmDriven, VehicleStatus vehicleStatus, int pricePerHour) {
        this.registrationNumber = registrationNumber;
        this.company = company;
        this.model = model;
        this.kmDriven = kmDriven;
        this.vehicleStatus = vehicleStatus;
        this.pricePerHour = pricePerHour;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public String getKmDriven() {
        return kmDriven;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
class Reservation {
    String id;
    RentalVehicle vehicle;
    int reservedHours;

    public Reservation(String id, RentalVehicle vehicle, int reservedHours) {
        this.id = id;
        this.vehicle = vehicle;
        this.reservedHours = reservedHours;
    }

    public String getId() {
        return id;
    }

    public RentalVehicle getVehicle() {
        return vehicle;
    }

    public int getReservedHours() {
        return reservedHours;
    }
}
class RentalUser {
    String id;
    String name;
    List<Reservation> reservations;

    public RentalUser(String id, String name, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.reservations = reservations;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
class UserCtrlRental {
    private List<RentalUser> users;

    public UserCtrlRental(List<RentalUser> users) {
        this.users = users;
    }

    public List<RentalUser> getUsers() {
        return users;
    }
    public void addUser(RentalUser user) {
        this.users.add(user);
    }
}
interface VehicleSearchStrategy {
    List<RentalVehicle> search(List<RentalVehicle> vehicles, String searchTerm);
}

class SearchByCompany implements VehicleSearchStrategy {

    @Override
    public List<RentalVehicle> search(List<RentalVehicle> vehicles, String searchTerm) {
        return vehicles.stream().filter(rentalVehicle -> rentalVehicle.getCompany().contains(searchTerm)).toList();
    }
}
class Inventory {
    List<RentalVehicle> vehicles;

    public Inventory(List<RentalVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<RentalVehicle> getVehicles(VehicleSearchStrategy searchStrategy, String searchTerm) {
        return searchStrategy.search(vehicles, searchTerm);
    }

    public List<RentalVehicle> getAllVehicle() {
        return vehicles;
    }
}
class Store {
    String storeId;
    String storeName;
    String address;
    Inventory inventory;

    public Store(String storeId, String storeName, String address, Inventory inventory) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        this.inventory = inventory;
    }

    public List<RentalVehicle> getAllVehicles() {
        return inventory.getAllVehicle();
    }

    public List<RentalVehicle> searchVehicles(VehicleSearchStrategy searchStrategy , String searchTerm) {
        return inventory.getVehicles(searchStrategy, searchTerm);
    }

    public Reservation createReservation(RentalUser user, RentalVehicle vehicle, int hours) {
        Reservation reservation = new Reservation("1", vehicle, hours);
        user.addReservation(reservation);
        return reservation;
    }

    public int generateBill(Reservation reservation) {
        return reservation.getReservedHours() * reservation.getVehicle().getPricePerHour();
    }
}
class StoreController {
    Map<City, List<Store>> cityVsStore;
    List<Store> allStores;

    public StoreController(Map<City, List<Store>> cityVsStore, List<Store> allStores) {
        this.cityVsStore = cityVsStore;
        this.allStores = allStores;
    }

    public List<Store> getStore(City city) {
        return cityVsStore.get(city);
    }

    public List<Store> getAllStores() {
        return allStores;
    }
}
class CarRentalSystem {
    UserCtrlRental userController;
    StoreController storeController;

    public CarRentalSystem(UserCtrlRental userController, StoreController storeController) {
        this.userController = userController;
        this.storeController = storeController;
    }

    public List<Store> getStores(City city) {
        return storeController.getStore(city);
    }
    public List<Store> getStores() {
        return storeController.getAllStores();
    }

}
public class CarRental {
    public static void main(String[] args) {
        List<RentalVehicle> vehicles = new ArrayList<>();
        vehicles.add(new RentalVehicle("1234", "Mercedes", "C-Class", "10000", VehicleStatus.AVAILABLE, 50));
        vehicles.add(new RentalVehicle("5678", "BMW", "3 Series", "15000", VehicleStatus.AVAILABLE, 60));
        vehicles.add(new RentalVehicle("9101", "Audi", "A4", "20000", VehicleStatus.AVAILABLE, 70));

        // Creating mock inventory
        Inventory inventory = new Inventory(vehicles);

        // Creating mock stores
        List<Store> storesInCity = new ArrayList<>();
        Store store = new Store("1", "Store1", "123 Street, Jammu", inventory);
        storesInCity.add(store);
        List<Store> allStore = new ArrayList<>();
        allStore.add(store);
        // Creating mock city to store mapping
        Map<City, List<Store>> cityVsStore = new HashMap<>();
        cityVsStore.put(new City(123, "Jammu"), storesInCity);

        // Creating StoreController
        StoreController storeController = new StoreController(cityVsStore, allStore);

        // Creating UserCtrlRental
        UserCtrlRental userController = new UserCtrlRental(new ArrayList<>());

        // Creating CarRentalSystem
        CarRentalSystem carRentalSystem = new CarRentalSystem(userController, storeController);

        // Creating mock user
        RentalUser user = new RentalUser("12", "Harsh", new ArrayList<>());
        userController.addUser(user);

        // Getting stores in a city
        List<Store> stores = carRentalSystem.getStores();

        // Assuming picking first store because it is the nearest
        Store selectedStore = stores.get(0);

        // Searching vehicles by company
        List<RentalVehicle> searchResults = selectedStore.searchVehicles(new SearchByCompany(), "Mercedes");
        for (RentalVehicle rentalVehicle : searchResults) {
            System.out.println(rentalVehicle.getCompany() + " " + rentalVehicle.getModel());
        }

        // Assuming we have selected the first vehicle
        RentalVehicle selectedVehicle = searchResults.get(0);
        Reservation reservation = store.createReservation(user, selectedVehicle, 10);
        System.out.println("Amount to be Paid: " + store.generateBill(reservation));

        // Setting vehicle status to BOOKED
        reservation.getVehicle().setVehicleStatus(VehicleStatus.BOOKED);
        System.out.println("Vehicle " + reservation.getVehicle().getRegistrationNumber() + " booked");

        // Verifying the reservation in user
        System.out.println("User's first reservation vehicle registration number: " + user.getReservations().get(0).getVehicle().getRegistrationNumber());
    }
}
