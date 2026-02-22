# 🚗 Smart Parking Management System (Java OOP Project)

A console-based Smart Parking Management System built using core Java concepts.  
This project demonstrates strong understanding of Object-Oriented Programming and Java Collections Framework.

---

## 📌 Project Objective

To design and implement a parking management system that:

- Manages different types of vehicles
- Handles parking capacity
- Maintains a waiting queue (FIFO)
- Calculates parking fees using polymorphism
- Demonstrates core OOP principles in Java

---

## 🧠 OOP Concepts Implemented

### 1️⃣ Encapsulation
- All class fields are declared `private`
- Data is accessed using public getter methods
- Internal state is protected from direct modification

---

### 2️⃣ Abstraction
- `Vehicle` is an abstract class
- Abstract method:
  ```java
  abstract int calculateFees();
  ```
- Each vehicle type defines its own fee calculation logic

---

### 3️⃣ Inheritance
Vehicle hierarchy:

```
Vehicle (Abstract Class)
   ├── Car
   ├── Bike
   └── Truck
```

Each subclass extends `Vehicle` and implements:
- `calculateFees()`
- `vehicleType()`

---

### 4️⃣ Polymorphism
Vehicles are stored using:

```java
ArrayList<Vehicle>
```

Fee calculation uses runtime polymorphism:

```java
Vehicle v = pm.removeVehicle(id);
v.calculateFees();
```

Method resolution happens at runtime based on object type.

---

### 5️⃣ Interface Implementation

Custom interface:

```java
interface Parkable
```

Methods:
- `boolean addVehicle(Vehicle vehicle);`
- `Vehicle removeVehicle(int id);`

Implemented by:

```
ParkingManager
```

This ensures contract-based design.

---

## 📚 Collections Used

### 🔹 ArrayList
Used to store currently parked vehicles.

Reason:
- Fast index-based access
- Dynamic resizing

---

### 🔹 LinkedList
Used as a FIFO waiting queue.

Reason:
- Efficient insertion/removal at beginning
- Queue behavior using `addLast()` and `removeFirst()`

---

## ⚙️ System Design

### Classes Overview

| Class | Responsibility |
|-------|---------------|
| `Vehicle` | Abstract base class for all vehicles |
| `Car`, `Bike`, `Truck` | Define specific fee logic |
| `Parkable` | Interface defining parking operations |
| `ParkingManager` | Manages parking lot and waiting queue |
| `UI` | Handles user interaction (console menu) |

---

## 🏗 Core Features

### ✅ Add Vehicle
- If parking has space → added to `ArrayList`
- If full → added to `LinkedList` waiting queue

---

### ✅ Remove Vehicle
- Vehicle removed by ID
- Parking fee calculated using polymorphism
- If queue not empty → first vehicle moved to parking

---

### ✅ Show Parked Vehicles
Displays:
- Vehicle Type
- Owner Name
- Vehicle ID
- Entry Time

---

### ✅ Show Waiting Queue
Displays vehicles waiting for parking slot.

---

## 💰 Parking Fee Structure

| Vehicle Type | Rate Per Hour |
|-------------|---------------|
| Car | ₹20 |
| Bike | ₹10 |
| Truck | ₹40 |

Fee Formula:

```
Fee = Rate × Hours
```

---

## 🖥 Sample Console Output

```
1.Add Vehicle
2.Remove Vehicle
3.Show Vehicles
4.Show Vehicle In Queue
5.Exit

Choose Option: 1
Enter Vehicle Type (Car/Bike/Truck): car
Enter Owner Name: Rahul
Enter Vehicle Num: 101
Enter Hours: 3

Vehicle Added Successfully!

Choose Option: 2
Enter Vehicle Number: 101

Vehicle Removed!
Total Fees: 60
```

---

## 🏎 Parking Flow Logic

```
IF parking_size < capacity
    → Add to parked list
ELSE
    → Add to waiting queue

When removing vehicle:
    → Remove from parked list
    → If queue not empty:
         Move first waiting vehicle to parking
```

---

## 📦 Technologies Used

- Java (Core)
- OOP Principles
- Java Collections Framework
- Console-based UI

---

## 🎯 Learning Outcomes

Through this project:

- Understood real-world OOP modeling
- Applied abstraction and polymorphism correctly
- Implemented interface-based design
- Used ArrayList and LinkedList with proper reasoning
- Built a clean console-driven system

---

## 🚀 Future Improvements

- Dynamic parking capacity
- Time-based fee calculation using `LocalDateTime`
- Data persistence (File handling / Database)
- GUI version using JavaFX or Swing
- HashMap for faster vehicle lookup

---

## 👨‍💻 Author

Built as a Java OOP practice project to strengthen core object-oriented programming fundamentals.
