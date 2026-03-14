# 🚗 Parking Lot Management System (Java CLI)

A simple **command-line parking lot management system** built using **Java** to practice object-oriented design and core data structures.

The project simulates how a parking system manages vehicles entering and leaving a parking lot while assigning slots and calculating parking fees.

The main focus of this project was to understand **how backend systems manage state using data structures**, rather than building a graphical interface.

---

## Features

• Register vehicles entering the parking lot
• Automatically assign the **nearest available parking slot**
• Remove vehicles when they leave
• Calculate parking fees based on parking duration
• Track currently parked vehicles
• Display available parking slots

The system runs entirely through a **CLI menu-based interface**.

---

## How the System Works

1. The user defines the **total number of parking slots** at startup.
2. When a vehicle enters:

   * The system checks if the vehicle is already parked.
   * It finds the **lowest available slot number**.
   * A parking ticket is generated.
3. When the vehicle leaves:

   * The system retrieves the ticket.
   * Calculates the parking fee.
   * Releases the parking slot.
4. The slot becomes available for the next vehicle.

---

## Technologies Used

**Language**

Java (Core Java)

**Concepts Practiced**

Object-Oriented Programming
Data Structures
State management in backend systems

---

## Data Structures Used

### ConcurrentHashMap

Stores active parking tickets.

Example:

vehicleNumber → ParkingTicket

Used for **fast lookup of parked vehicles**.

---

### HashSet

Stores vehicles currently inside the parking lot.

Purpose:

• Prevent duplicate vehicle entry
• Quickly check if a vehicle is already parked

---

### TreeSet

Stores available parking slots.

TreeSet automatically keeps slots **sorted**, allowing the system to always assign the **nearest available slot**.

Example:

Slots available → [1,2,3,4]

Vehicle arrives → Slot **1** is assigned.

---

## Project Structure

```id="f4x9ti"
ParkingSystem1
│
├── Vehicle.java
│
├── ParkingTicket.java
│
├── ParkingManager.java
│
└── ParkingSystem_UI.java
```

### Vehicle

Represents a vehicle entering the parking lot.

Stores:

• vehicle number

---

### ParkingTicket

Represents the ticket generated when a vehicle enters.

Contains:

• ticket id
• vehicle
• slot number
• parking duration
• fee calculation logic

---

### ParkingManager

Handles the main business logic of the system.

Responsibilities:

• registering vehicles
• assigning parking slots
• removing vehicles
• calculating parking fees
• managing parking state

This class maintains the data structures used by the system.

---

### ParkingSystem_UI

Provides the **command-line interface** for user interaction.

Displays the menu and handles user input.

---

## Example CLI Interaction

```id="22l3kc"
Enter Total Slots In Parking: 5

1.Register Vehicle
2.Remove Vehicle
3.Free Slots
4.Registered Vehicles
5.Exit

Choose Option: 1

Enter Vehicle Number: 1234
Enter Vehicle Duration: 2

Vehicle Registered Successfully!
```

Removing a vehicle:

```id="dx9dnp"
Enter Vehicle Number: 1234

Ticket ID: 101
Appointed Slot: 1
Vehicle Number: 1234
Duration: 2
Fees: 60

Vehicle Removed!
```

---

## What I Learned

While building this project I practiced:

• Designing classes for real-world systems
• Managing system state using collections
• Preventing duplicate entries with sets
• Using sorted data structures for efficient allocation
• Separating UI logic from business logic

This project helped me better understand how backend systems organize and manage data internally.

---

## Future Improvements

Possible improvements for this system:

• Track entry and exit time automatically
• Support multiple parking floors
• Add vehicle types (car, bike, EV)
• Implement a reservation system
• Store parking data in a database

---

## Author

Built as a practice project while learning **Java backend fundamentals, OOP design, and data structures**.
