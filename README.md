
# CRUD Operations with JDBC and PostgreSQL

## Overview

This repository demonstrates how to perform CRUD (Create, Read, Update, Delete) operations using Java Database Connectivity (JDBC) with a PostgreSQL database. The project showcases how to interact with a PostgreSQL database from a Java application, covering the essential database operations.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Technologies Used](#technologies-used)

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- PostgreSQL database server
- JDBC Driver for PostgreSQL
- An IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse, VS Code)

## Setup

1. **Database Setup:**
   - Create a PostgreSQL database.
   - Update the connection details in the `DatabaseConfig.java` file with your database's host, port, database name, username, and password.

2. **Project Setup:**
   - Open the project in your IDE.
   - Ensure the PostgreSQL JDBC driver is added to your project's classpath.

3. **Build and Run:**
   - Compile the project and run the application.
   - The application will connect to the PostgreSQL database and perform the CRUD operations.


## Technologies Used

- **Java**: The programming language used to implement the application.
- **JDBC**: The API used to connect and execute queries on the PostgreSQL database.
- **PostgreSQL**: The relational database used for data storage.
