A simple REST API using Spring Boot and MySQL to manage employees and their leave requests

Created the project in C:\Users\Administrator\Downloads\leave-management12.

Prerequisites:

Java 17 or above

Spring Boot 3.x

MySQL database

IDE (IntelliJ)

Postman (for testing APIs)
----------------------------------------------------------------------------------------------

1)Initialized Git in that folder:

git init
git add .
git commit -m "Initial commit - Leave Management API"


2)Configured my Git identity:

git config --global user.name "Pratheeksha Kulal"
git config --global user.email "pratheeksha10@example.com"


3)Added remote repository and pushed:

git remote add origin https://github.com/Pratheeksha-dev/leave-management.git
git push -u origin master


Setup & Run

Clone or download this repository

git clone https://github.com/Pratheeksha-dev/leave-management.git


Open project in IDE (IntelliJ)

Configure MySQL

Create a database, e.g., leave_management.

Update src/main/resources/application.properties with your database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/leave_management
spring.datasource.username=root
spring.datasource.password=Pratheeksha@10
spring.jpa.hibernate.ddl-auto=update


Run the project

Right-click LeaveManagementApplication.java → Run as Java Application.

Or click the Run button in your IDE.

Test APIs using Postman

Employee APIs

POST /employees → Add employee

GET /employees → Get all employees

GET /employees/{id} → Get one employee

PUT /employees/{id} → Update employee

DELETE /employees/{id} → Delete employee

Leave APIs

POST /leaves → Create leave request

GET /leaves → Get all leave requests

GET /leaves/{id} → Get one leave request

GET /leaves/employee/{employeeId} → Get leaves for an employee

PUT /leaves/{id}/status?status=APPROVED → Approve/Reject a leave request

Employee API

1. Create Employee (POST /employees)
Request Body (JSON):

{
  "name": "Pratheeksha",
  "email": "pratheeksha@gmail.com",
  "department": "IT"
}


2. Get All Employees (GET /employees)
Response Example:

[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "department": "IT"
  },
  {
    "id": 2,
    "name": "Pratheeksha",
    "email": "pratheeksha@gmail.com",
    "department": "IT"
  }
]


3. Get Employee by ID (GET /employees/{id})
Response Example:

{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "department": "IT"
}


4. Update Employee (PUT /employees/{id})
Request Body (JSON):

{
  "name": "Pratheeksha K",
  "email": "prathee10@gmail.com",
  "department": "IT"
}


5. Delete Employee (DELETE /employees/{id})
Response:

Status OK (no body)

LeaveRequest API

get http://localhost:8080/leaves -- shows all created list
post http://localhost:8080/leaves -- adds 

1. Create LeaveRequest (POST /leaves)
Request Body (JSON):

{
  "employeeId": 1,
  "startDate": "2025-10-01",
  "endDate": "2025-10-03",
  "reason": "Medical leave"
}


2. Get All LeaveRequests (GET /leaves)
Response Example:

[
  {
    "id": 1,
    "employeeId": 1,
    "startDate": "2025-10-01",
    "endDate": "2025-10-03",
    "reason": "Medical leave",
    "status": "PENDING"
  }
]


3. Get LeaveRequest by ID (GET /leaves/{id})
Response Example:

{
  "id": 1,
  "employeeId": 1,
  "startDate": "2025-10-01",
  "endDate": "2025-10-03",
  "reason": "Medical leave",
  "status": "PENDING"
}
---------------------------------------------------------------------------------------------------------------------------------------------------
Access in Browser or Postman

Base URL: http://localhost:8080

Base URL: http://localhost:8080/employees

Employee APIs:

GET /employees → List all employees

GET /employees/{id} → Get employee by ID

POST /employees → Add employee

PUT /employees/{id} → Update employee

DELETE /employees/{id} → Delete employee

LeaveRequest APIs:

GET /leaves → List all leave requests

GET /leaves/{id} → Get leave request by ID

GET /leaves/employee/{employeeId} → Get leaves for specific employee

POST /leaves → Create leave request

PUT /leaves/{id}/status?status=APPROVED → Approve or reject leave






