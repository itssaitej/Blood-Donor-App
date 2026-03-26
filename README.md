# Blood Donor App 🩸

A Spring Boot backend application for managing blood donors.

## Features
- User Registration & Login
- Donor CRUD Operations
- Search by City, Area, Blood Group
- Availability Tracking

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- H2 Database

## API Testing (Postman)

### Register
POST /auth/register

Body:
{
  "username": "tej",
  "password": "1234",
  "name": "Tej Sai",
  "bloodGroup": "O+",
  "city": "Hyderabad",
  "area": "Madhapur",
  "location": "Near Metro",
  "available": true
}

### Get Donors
GET /donors

### Search
GET /donors/search?city=Hyderabad

## How to Run 🚀

1. Clone the repository:
   git clone https://github.com/itssaitej/Blood-Donor-App.git

2. Navigate into the project:
   cd Blood-Donor-App

3. Run the application:
   mvn spring-boot:run

4. Server will start at:
   http://localhost:8080

## Database

This project uses H2 in-memory database.

Access H2 Console:
http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)   

## Future Improvements
- JWT Authentication
- React Frontend
- Location-based search
