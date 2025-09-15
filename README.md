# Fitness Tracker

A comprehensive fitness tracking application built with Spring Boot that enables users to monitor their workouts, manage diet plans, set fitness goals, and track their overall health progress.

## Features

### User Management
- User registration and authentication
- Secure login with JWT token-based authentication
- User profile management

### Workout Tracking
- Log workout sessions with detailed exercise information
- Track workout history and progress
- Create and manage custom workout routines
- View workout statistics and analytics

### Diet Management
- Log daily food intake and calories
- Track nutritional information
- Monitor dietary habits and patterns
- Food logging with comprehensive nutritional data

### Goal Setting
- Set and track fitness goals
- Monitor progress towards achieving targets
- Goal management with deadlines and milestones
- Visual progress tracking

### Statistics and Analytics
- Comprehensive dashboard with key metrics
- Historical data analysis
- Progress visualization
- User activity statistics

## Technology Stack

- **Backend Framework**: Spring Boot 3.5.5
- **Database**: MySQL
- **Security**: Spring Security with JWT authentication
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Java Version**: 21

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Validation
- MySQL Connector
- JWT (JSON Web Token) Library
- Lombok
- Spring Boot Starter Test

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/GauravKumarSaini/fittracker.git
   cd fittracker
   ```

2. Configure the database:
   - Create a MySQL database named `fitnessTracker`
   - Update the database configuration in `src/main/resources/application.properties`

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## Database Configuration

Update the following properties in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitnessTracker
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## API Endpoints

### Authentication
- `POST /api/auth/signup` - User registration
- `POST /api/auth/login` - User login

### Workouts
- `GET /api/workouts` - Get user workouts
- `POST /api/workouts/log` - Log a new workout

### Diet
- `GET /api/diet/logs` - Get food logs
- `POST /api/diet/log` - Log food intake

### Goals
- `GET /api/goals` - Get user goals
- `POST /api/goals` - Create a new goal
- `PUT /api/goals/{id}` - Update a goal
- `DELETE /api/goals/{id}` - Delete a goal

### Routines
- `GET /api/routines` - Get user routines
- `POST /api/routines` - Create a new routine

### Statistics
- `GET /api/statistics/dashboard` - Get dashboard statistics

## Project Structure

```
src/
├── main/
│   ├── java/com/fitnessTracker/
│   │   ├── controller/          # REST Controllers
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── model/               # Entity Classes
│   │   ├── repository/          # Data Access Layer
│   │   ├── security/            # Security Configuration
│   │   └── service/             # Business Logic Layer
│   └── resources/
│       └── application.properties
└── test/                        # Test Classes
```

## Security

The application implements JWT-based authentication with the following security features:

- Password encryption using BCrypt
- JWT token generation and validation
- Secure API endpoints with role-based access
- CORS configuration for cross-origin requests

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions, please open an issue in the GitHub repository.
