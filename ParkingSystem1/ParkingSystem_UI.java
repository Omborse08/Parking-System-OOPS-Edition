package ParkingSystem1;
import java.util.*;

public class ParkingSystem_UI{
    static void showMenu() {
        System.out.println("1.Register Vehicle\n2.Remove Vehicle\n3.Free Slots\n4.Registered Vehicles\n5.Exit");
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Total Slots In Parking: ");
        int slots = sc.nextInt();
        ParkingManager manager = new ParkingManager(slots);
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    int number = sc.nextInt();
                    System.out.print("Enter Vehicle Duration: ");
                    int duration = sc.nextInt();
                    if (duration < 0) {
                        Vehicle vehicle = new Vehicle(number);
                        if (manager.addVehicle(vehicle, duration)) {
                            System.out.println("Vehicle Registred Successfully!");
                        } else {
                            System.out.println("Something Went Wrong Try Again Later!");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    int removeNumber = sc.nextInt();
                    if (manager.removeVehicle(removeNumber)) {
                        System.out.println("Vehicle Removed!");
                    }
                    else {
                        System.out.println("No Vehicle Registred Yet!");
                    }
                    break;

                case 3:
                    manager.freeSlots();
                    break;

                case 4:
                    manager.RegistredVehicles();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    isRunning = false;
                    break;
            }
        }
    }
}
