# Mail Master - Email Management System

A Java-based email management system for managing emails, contacts, and user accounts with a modular architecture.

## Features

### User Management
- User registration with email and password authentication
- User profiles with name, email, date of birth, and creation timestamp

### Email Management
- Compose and send emails with subject and body content
- Draft management for saving emails for later editing
- Email search and organization
- Separate management of sent and received emails

### Contact Management
- Store contact information including names and mobile numbers
- Contact search and management functionality
- Add, edit, and manage contact entries

## Project Structure

```
src/com/zsgs/mailmaster/
├── Main.java                          # Application entry point
├── data/                              # Data layer
│   ├── db/
│   │   └── MailRepository.java        # Data repository and storage
│   └── dto/                           # Data Transfer Objects
│       ├── User.java                  # User entity
│       ├── Mail.java                  # Email entity
│       └── Contact.java               # Contact entity
└── features/                          # Feature modules
    ├── registration/                  # User registration
    │   ├── RegistrationModel.java
    │   └── RegistrationView.java
    ├── mail/                          # Email management
    │   ├── manage/
    │   ├── search/
    │   └── details/
    ├── contact/                       # Contact management
    │   ├── manage/
    │   ├── search/
    │   └── details/
    └── utils/                         # Utility classes
```

## Technology Stack

- **Language**: Java
- **Architecture**: Model-View Pattern
- **Data Storage**: In-memory storage with Map-based repositories

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, VS Code)

### Installation

1. Clone the repository
2. Open in your IDE
3. Run the application:
   ```bash
   cd src
   javac com/zsgs/mailmaster/Main.java
   java com.zsgs.mailmaster.Main
   ```

## Architecture

### Model-View Pattern
- **Model**: Contains business logic and data manipulation
- **View**: Handles user interface and creates the Model instance
- **Direct Communication**: View directly communicates with its Model

### Repository Pattern
- Centralized data access through `MailRepository`
- In-memory storage using Java Collections (Maps)

## Data Models

### User
- `id`: Unique user identifier
- `name`: User's full name
- `email`: User's email address
- `password`: Encrypted password
- `dob`: Date of birth
- `createAt`: Account creation timestamp

### Mail
- `mailId`: Unique email identifier
- `senderId`: ID of the sender
- `subject`: Email subject line
- `body`: Email content
- `sendAt`: Timestamp when sent
- `isDraft`: Draft status flag

### Contact
- `id`: Unique contact identifier
- `userId`: ID of the user who owns this contact
- `contactName`: Contact's name
- `mobNum`: Contact's mobile number

### Coding Standards
- Follow Java naming conventions
- Use meaningful variable and method names
- Maintain the Model-View pattern structure
- Add comments for complex logic 
