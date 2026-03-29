# 🏨 Hotel Booking Management System


## Overview

The **Hotel Booking Management System** is a Java-based object-oriented program designed to simulate a simplified hotel reservation system. The system allows guests to book rooms, manage reservations, add charges, and process payments while employees manage check-ins, check-outs, and reservations.

This project demonstrates core **Object-Oriented Programming (OOP)** principles including:

* Encapsulation
* Inheritance
* Abstraction
* Interfaces
* Class relationships
* Unit testing

The goal of the system is to model how hotels manage rooms, guests, reservations, and billing operations.

---

## Hotel Features

The system supports the following functionality:

* Guests can reserve hotel rooms
* Guests can view reservations and manage payments
* Employees can check guests in and out
* Rooms can be marked available or occupied
* Charges (such as room service or amenities) can be added to guest accounts
* Total charges are tracked and processed
* Guest can leave ratings
---

## System Design

### Main Classes

---
- Hotel
- Guest (implements Chargeable)
- Employee
- Reservation (implements Chargeable)
- Room (abstract)
  - SingleRoom
  - DoubleRoom
  - SuiteRoom

---

## Key Concepts Used
- Inheritance
- Interfaces
- Abstract classes
- Encapsulation
- Exception handling
- Unit testing (JUnit)

---

## How to Run
1. Open project in an IDE (IntelliJ, Eclipse, VS Code)
2. Run `Main.java`
3. Follow console prompts

---
Contributors:
Adithi Vaishnavi Vuligonda, Aditya Nagpal, David Aguiniga, Thy Le
---
Adithi's contribution - I worked on the Chargeable interface, Employee and Reservation classes, and the test cases for Employee, Reservation, and Guest classes.

Aditya's contribution -

David's contribution - I created the Guest class for our project, I would also create the tests for that class. I would communicate with my other groupmates, specifically those who created employees class and the chargeable interface. I also created the first draft/outline of our readme.

Thy's contribution -
