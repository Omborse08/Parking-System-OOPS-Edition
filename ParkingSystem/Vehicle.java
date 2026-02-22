package ParkingSystem;
import java.util.*;
import java.time.*;

abstract class Vehicle{
    private int number;
    private String name;
    private String time;

    public int getHourse() {
        return hourse;
    }

    private int hourse;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    Vehicle(String name,int number,int hours) {
        this.name = name;
        this.number = number;
        this.hourse = hours;
        this.time = new Date().toString();
    }

    abstract int calculateFees();
    abstract String vehicleType();
}

class Car extends Vehicle {
    static final int fees = 20;
    Car(String name,int number,int hourse) {
        super(name,number,hourse);
    }
    @Override
    int calculateFees() {
        return fees * getHourse();
    }

    @Override
    String vehicleType() {
        return "Car";
    }
}

class Bike extends Vehicle {
    static final int fees = 10;
    Bike(String name,int number,int hourse) {
        super(name,number,hourse);
    }
    @Override
    int calculateFees() {
        return fees * getHourse();
    }

    @Override
    String vehicleType() {
        return "Bike";
    }
}

class Truck extends Vehicle {
    static final int fees = 40;
    Truck(String name,int number,int hourse) {
        super(name,number,hourse);
    }
    @Override
    int calculateFees() {
        return fees * getHourse();
    }
    @Override
    String vehicleType() {
        return "Truck";
    }
}

interface Parkable {
    boolean addVehicle(Vehicle vehicle);
    Vehicle removeVehicle(int id);
}

class ParkingManager implements Parkable {
    private ArrayList<Vehicle> vehicles;
    private LinkedList<Vehicle> waitingQueue;
    private int capacity;

    ParkingManager(int cap) {
        this.capacity = cap;
        vehicles = new ArrayList<>(2);
        waitingQueue = new LinkedList<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            if (vehicles.size() < capacity) {
                vehicles.add(vehicle);
                return true;
            }
            else {
                waitingQueue.addLast(vehicle);
            }
        }
        return false;
    }

    public Vehicle removeVehicle(int id) {
        Vehicle temp;
        for (int i=0;i < vehicles.size();i++) {
            if (id==vehicles.get(i).getNumber()) {
                temp = vehicles.get(i);
                vehicles.remove(i);
                if (!waitingQueue.isEmpty()) {
                    vehicles.add(waitingQueue.removeFirst());
                }
                return temp;
            }
        }
        return null;
    }

    void showVehicle() {
        for (int i=0;i<vehicles.size();i++) {
            Vehicle v = vehicles.get(i);
            System.out.println("Vehicle Type: "+v.vehicleType());
            System.out.println("Vehicle Owner: "+v.getName());
            System.out.println("Vehicle ID: "+v.getNumber());
            System.out.println("Vehicle Time: "+v.getTime());
            System.out.println("+=================================+");
        }
    }

    void WaitingshowVehicle() {
        for (int i=0;i<waitingQueue.size();i++) {
            Vehicle v = waitingQueue.get(i);
            System.out.println("Vehicle Type: "+v.vehicleType());
            System.out.println("Vehicle Owner: "+v.getName());
            System.out.println("Vehicle ID: "+v.getNumber());
            System.out.println("Vehicle Time: "+v.getTime());
            System.out.println("+=================================+");
        }
    }
}


class UI {
    static void show() {
        System.out.println("1.Add Vehicle\n2.Remove Vehicle\n3.Show Vehicles\n4.Show Vehicle In Queue\n5.Exit");
    }
    static void main(String[] args) {
        System.out.println("<+><+><+> PARKING <+><+><+>");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Capacity: ");
        int cap = sc.nextInt();
        ParkingManager pm = new ParkingManager(cap);
        boolean isRun = true;
        show();
        while (isRun) {
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
                    String type = sc.nextLine().toLowerCase();
                    System.out.print("Enter Owner Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Vehicle Num: ");
                    int num = sc.nextInt();
                    System.out.print("Enter Hours: ");
                    int hourse = sc.nextInt();
                    Vehicle vehicle = null;
                    if (type.equals("car")) {
                        vehicle = new Car(name,num,hourse);
                    }
                    else if (type.equals("bike")) {
                        vehicle = new Bike(name,num,hourse);
                    } else if (type.equals("truck")) {
                        vehicle = new Truck(name,num,hourse);
                    }
                    else {
                        System.out.println("Wrong Check Again!");
                    }
                    if (pm.addVehicle(vehicle)) {
                        System.out.println("Vehicle Added Successfully!");
                    }
                    else {
                        System.out.println("Vehicle Added in Queue!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    int removeNum = sc.nextInt();
                    Vehicle v = pm.removeVehicle(removeNum);
                    if (v != null) {
                        System.out.println("Vehicle Removed!");
                        System.out.println("Total Fees: "+v.calculateFees());
                    }
                    else {
                        System.out.println("Check Vehicle Id Again!");
                    }
                    break;

                case 3:
                    System.out.println("\n<+> Show Parked Vehicles <+>");
                    System.out.println("+=================================+");
                    pm.showVehicle();
                    break;

                case 4:
                    System.out.println("\n<+> Show Waiting Queue Vehicles <+>");
                    System.out.println("+=================================+");
                    pm.WaitingshowVehicle();
                    break;

                case 5:
                    System.out.println("Thank You Bye!");
                    isRun = false;
                    break;
            }
        }
    }
}

