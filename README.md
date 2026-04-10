Student Feedback Management System – Backend

🌐 Deployment Links

Backend API: https://fullstacksdp33backend-production.up.railway.app/

Frontend Application: https://fullstack-sdp33-frontend-i171.vercel.app/

---

📌 Project Overview
This backend is developed using Spring Boot for the Student Feedback System.  
It provides RESTful APIs to manage users, admins, courses, and feedback, with data stored in a MySQL database.
The application is deployed on Railway and connected to a cloud database for real-time data handling.

---

🛠️ Tech Stack
- Spring Boot
- MySQL
- Hibernate / JPA
- Maven
- Railway (Deployment)

---

✨ Features
- User & Admin Authentication (Login / Signup)
- Profile Management
- Course Management (CRUD)
- Feedback Submission & Retrieval
- RESTful API Integration
- CORS enabled for frontend communication

---

📡 Sample API Endpoints

You can test the backend directly using these endpoints:

- **Get All Users**  
  https://fullstacksdp33backend-production.up.railway.app/api/users

- **Get All Admins**  
  https://fullstacksdp33backend-production.up.railway.app/api/admins

- **Get All Courses**  
  https://fullstacksdp33backend-production.up.railway.app/api/courses

- **Get All Feedback**  
  https://fullstacksdp33backend-production.up.railway.app/api/feedback

These endpoints return JSON responses and can be tested using a browser or tools like Postman.

---

⚙️ Configuration
Set the following environment variables:
DB_URL=your_database_url
DB_USERNAME=your_username
DB_PASSWORD=your_password
SERVER_PORT=8080


---

▶️ Running Locally

mvn spring-boot:run


Backend runs at:  
http://localhost:8080

---

📡 API Base URL
http://localhost:8080/api

---

📂 Database
The application uses MySQL with tables such as:
- User
- Admin
- Course
- Feedback

Schema is automatically generated using Hibernate.

---

🚀 Deployment
The backend is deployed on Railway.  

🔗 Live Backend:  
https://fullstacksdp33backend-production.up.railway.app/

---

🔗 Integration
This backend is fully connected with the frontend deployed on Vercel, enabling seamless data exchange.
