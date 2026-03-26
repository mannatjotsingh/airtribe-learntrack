# Design Notes

## Why ArrayList instead of Array?

ArrayList is used because:

* It provides dynamic resizing
* Easy to add/remove elements
* Suitable for unknown number of records

## Where Static Members Were Used

Static members are used in IdGenerator class:

* To generate unique IDs for students, courses, and enrollments

## Where Inheritance Was Used

Inheritance is implemented using:

* Person (base class)
* Student extends Person

This helps in:

* Code reuse
* Avoiding duplication of common fields like name and email

## Separation of Concerns

The project is divided into layers:

* Entity layer: Data representation
* Service layer: Business logic
* UI layer: User interaction

This improves readability and maintainability.
