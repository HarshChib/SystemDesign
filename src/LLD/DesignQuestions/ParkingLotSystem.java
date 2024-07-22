package LLD.DesignQuestions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

enum VehicleType {
    TWO_WHEELER,
    THREE_WHEELER,
    FOUR_WHEELER
}

class ParkingSpot {
    int id;
    VehicleType vehicleType;
    boolean isEmpty = true;

    public ParkingSpot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public void updateSpot(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}

class Vehicle{
    int vehicleNumber;
    VehicleType vehicleType;


    public Vehicle(int vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}

class ParkingSlip {
    int id;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalTime startTime;

    public ParkingSlip(Vehicle vehicle, ParkingSpot parkingSpot){
        this.id = vehicle.vehicleNumber;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.startTime = LocalTime.now();
    }

    public long calculateAmount(){
        return Duration.between(startTime , LocalTime.now()).toMinutes();
    }
}

class Bill{
    int id;
    boolean isPaid;
    long amount;

    public Bill(int id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

class ParkingLot {
    List<ParkingSpot> parkingSpots;
    Map<Integer, ParkingSlip> parkingSlips;

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
        this.parkingSlips = new HashMap<>();
    }

    public ParkingSlip generateSlip(Vehicle vehicle) {
        ParkingSpot spot = parkingSpots.get(0);
        ParkingSlip slip = new ParkingSlip(vehicle, parkingSpots.get(0));
        parkingSlips.put(vehicle.vehicleNumber, slip);
        return slip;
    }

    public void payBill(Bill bill) {
        bill.setPaid(true);
        System.out.println("Bill paid with amount : " + bill.amount);
    }

    public Bill generateBill(int vehicleNumber){
        ParkingSlip slip = parkingSlips.get(vehicleNumber);
        long amount = slip.calculateAmount();
        System.out.println("Billing amount for vehicle number :" + slip.vehicle.vehicleNumber +" is Rupees: "+ amount);
        return new Bill(slip.id, amount);
    }
}

public class ParkingLotSystem {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = getParkingSpots();
        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        Vehicle vehicle = new Vehicle(1254, VehicleType.FOUR_WHEELER);
        parkingLot.generateSlip(vehicle);
        Bill bill = parkingLot.generateBill(vehicle.vehicleNumber);
        parkingLot.payBill(bill);

    }

    private static List<ParkingSpot> getParkingSpots() {
        return List.of(new ParkingSpot(1, VehicleType.FOUR_WHEELER), new ParkingSpot(1, VehicleType.FOUR_WHEELER));
    }


}
