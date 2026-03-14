package ParkingSystem1;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ParkingManager{
    ConcurrentHashMap<Integer,ParkingTicket> vehicle = new ConcurrentHashMap<>();
    HashSet<Integer> vehicleInside = new HashSet<>();
    TreeSet<Integer> slots = new TreeSet<>();
    int TicketID = 101;

    ParkingManager(int slots) {
        for (int i=1;i<=slots;i++) {
            this.slots.add(i);
        }
    }

    public boolean addVehicle(Vehicle vehicle,int hours) {
        if (vehicleInside.contains(vehicle.getVehicleNumber())) {
            return false;
        }
        if (slots.isEmpty()) {
            return false;
        }
        vehicleInside.add(vehicle.getVehicleNumber());
        ParkingTicket parkingTicket = new ParkingTicket(TicketID,vehicle,slots.first(),hours);
        this.vehicle.put(vehicle.getVehicleNumber(),parkingTicket);
        slots.pollFirst();
        TicketID++;
        return true;
    }

    public boolean removeVehicle(int vehicleID) {
        if (vehicleInside.contains(vehicleID)) {
            ParkingTicket ticket = vehicle.get(vehicleID);
            System.out.println("Ticket ID: "+ticket.getTicketid());
            System.out.println("Appointed Slot: "+ticket.getSlotNuber());
            System.out.println("Vehicle Number: "+ticket.getVehicle().getVehicleNumber());
            System.out.println("Duration: "+ticket.getHours());
            System.out.println("Fees: "+ticket.getFees());
            slots.add(ticket.getSlotNuber());
            vehicleInside.remove(vehicleID);
            vehicle.remove(vehicleID);
            return true;
        }
        return false;
    }

    public void freeSlots() {
        for (int i: slots) {
            System.out.println("Slots "+i+" Is Empty!");
        }
    }

    public void RegistredVehicles() {
        if (vehicle.isEmpty()) {
            System.out.println("No Vehicle Registred Yet!");
        }
        else {
            System.out.println("Registred And Parked Vehicles");
            for (int i: vehicle.keySet()) {
                System.out.println("Vehicle Number Plate: "+vehicle.get(i).getVehicle().getVehicleNumber());
            }
        }
    }
}
