# 📚 LearnTrack – Student & Course Management System

## 🚀 Project Overview

LearnTrack is a console-based application built using Core Java that allows management of:

 Students
 Courses
 Enrollments

The application is menu-driven and runs in the terminal. It demonstrates strong understanding of Java fundamentals and Object-Oriented Programming (OOP).

---

## 🎯 Features

### 👨‍🎓 Student Management

* Add new student
* View all students
* Search student by ID
* Deactivate a student (soft delete using active flag)

### 📘 Course Management

* Add new course
* View all courses
* Activate / Deactivate course

### 🔗 Enrollment Management

* Enroll a student in a course
* View enrollments for a student
* Mark enrollment as COMPLETED or CANCELLED

---

## 🧠 Concepts Covered

* Java Basics (variables, loops, conditionals)
* OOP Principles:

  * Encapsulation
  * Inheritance
  * Polymorphism (method overriding)
* Constructor Overloading
* Collections (ArrayList)
* Exception Handling (Custom Exception)
* Static vs Instance members
* Clean Code and Modular Design

---


## ▶️ How to Run

### Step 1: Compile


javac   <filename.java>

### Step 2: Run

java <filename>
Note:-filename is without java extension only filename eg Main

## ⚙️ Design Highlights

* Used **ArrayList** for dynamic data storage
* Implemented **soft delete** using active flag instead of removing records
* Used **custom exception (EntityNotFoundException)** for better error handling
* Separated logic into **entity, service, and UI layers**

---

## 📘 Documentation

Detailed documentation is available in the `/docs` folder:

* Setup Instructions
* JVM Basics
* Design Notes

---
