# BatiCuisine

## Overview
BatiCuisine is a Java-based application designed to manage projects, clients, estimates, and related components in the construction domain. The application is structured in layers, following best practices and utilizing various Java features and design patterns.

## Technical Requirements
- **Java Version**: Java 8
- **Database**: PostgreSQL
- **Key Features**:
    - Stream API
    - Collections and HashMaps
    - Optional for handling optional values
    - Enums for representing fixed sets of constants
    - Repository Pattern for data access
    - Singleton design pattern for shared resources
    - Data validation (including date validation)
    - Java Time API for date management
    - Organized application layers (Service, Repository, etc.)

## Setup Instructions

### Prerequisites
- Java 8 installed
- PostgreSQL installed and running
- A PostgreSQL database created (e.g., BatiCuisine)

### Project Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/sanaa-ennaji/BatiCuisine.git
   cd BatiCuisine

2. **Database Configuration:**:

- Update your PostgreSQL connection settings in the DatabaseConnection.java file to match your local database credentials.
- run the sql script in the tables.sql file in pgadmin .

3. **Database Configuration:**:
   ```bash
   javac -d bin src/main/java/ma/Bati/*.java 

4. **Run the Application**:
   ```bash
   java -cp bin ma.Bati.Main


  
