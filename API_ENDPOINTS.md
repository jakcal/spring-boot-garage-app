# Spring Boot Garage Management API Endpoints

This document outlines the API endpoints and data types used in the Spring Boot Garage Management application.

## Data Types (Models)

Based on the application's domain, the following data models are expected:

### Garage
Represents a garage entity.

```markdown
- id: Long
- name: String
- address: String
- phoneNumber: String
```

### Service
Represents a service offered by the garage.

```markdown
- id: Long
- name: String
- description: String
- price: Double
```

### Client
Represents a client of the garage.

```markdown
- id: Long
- firstName: String
- lastName: String
- email: String
- phoneNumber: String
```

### RendezVous (Appointment)
Represents an appointment scheduled at the garage.

```markdown
- id: Long
- client: Client (reference)
- date: Date/LocalDateTime
- time: Time/LocalDateTime
- service: Service (reference)
- status: String (e.g., Scheduled, Completed, Cancelled)
```

### Employe (Employee)
Represents an employee working at the garage.

```markdown
- id: Long
- firstName: String
- lastName: String
- position: String
- phoneNumber: String
```

### Stock (Inventory)
Represents an item in the garage's inventory.

```markdown
- id: Long
- name: String
- description: String
- quantity: Integer
- price: Double
```

### Facture (Invoice)
Represents an invoice generated for a service or repair.

```markdown
- id: Long
- rendezVous: RendezVous (reference)
- client: Client (reference)
- date: Date/LocalDateTime
- totalAmount: Double
- status: String (e.g., Paid, Pending, Cancelled)
- items: List<FactureItem> (reference)
```

### FactureItem (Invoice Item)
Represents an item on an invoice (e.g., a service or a stock item).

```markdown
- id: Long
- facture: Facture (reference)
- description: String
- quantity: Integer
- unitPrice: Double
- subtotal: Double
```

## API Endpoints

The following endpoints are available:

### Garage Endpoints (`/api/garages`)

- `POST /api/garages`
  - Description: Create a new garage.
  - Request Body: `Garage` object.
  - Response Body: Created `Garage` object.

- `GET /api/garages`
  - Description: Get all garages.
  - Response Body: List of `Garage` objects.

- `GET /api/garages/{id}`
  - Description: Get a garage by ID.
  - Response Body: `Garage` object.

- `PUT /api/garages/{id}`
  - Description: Update a garage by ID.
  - Request Body: `Garage` object with updated details.
  - Response Body: Updated `Garage` object.

- `DELETE /api/garages/{id}`
  - Description: Delete a garage by ID.
  - Response Body: None (204 No Content).

### Service Endpoints (`/api/services`)

- `POST /api/services`
  - Description: Create a new service.
  - Request Body: `Service` object.
  - Response Body: Created `Service` object.

- `GET /api/services`
  - Description: Get all services.
  - Response Body: List of `Service` objects.

- `GET /api/services/{id}`
  - Description: Get a service by ID.
  - Response Body: `Service` object.

- `PUT /api/services/{id}`
  - Description: Update a service by ID.
  - Request Body: `Service` object with updated details.
  - Response Body: Updated `Service` object.

- `DELETE /api/services/{id}`
  - Description: Delete a service by ID.
  - Response Body: None (204 No Content).

### Client Endpoints (`/api/clients`)

- `POST /api/clients`
  - Description: Create a new client.
  - Request Body: `Client` object.
  - Response Body: Created `Client` object.

- `GET /api/clients`
  - Description: Get all clients.
  - Response Body: List of `Client` objects.

- `GET /api/clients/{id}`
  - Description: Get a client by ID.
  - Response Body: `Client` object.

- `PUT /api/clients/{id}`
  - Description: Update a client by ID.
  - Request Body: `Client` object with updated details.
  - Response Body: Updated `Client` object.

- `DELETE /api/clients/{id}`
  - Description: Delete a client by ID.
  - Response Body: None (204 No Content).

### RendezVous Endpoints (`/api/rendezvous`)

- `POST /api/rendezvous`
  - Description: Create a new appointment.
  - Request Body: `RendezVous` object.
  - Response Body: Created `RendezVous` object.

- `GET /api/rendezvous`
  - Description: Get all appointments.
  - Response Body: List of `RendezVous` objects.

- `GET /api/rendezvous/{id}`
  - Description: Get an appointment by ID.
  - Response Body: `RendezVous` object.

- `PUT /api/rendezvous/{id}`
  - Description: Update an appointment by ID.
  - Request Body: `RendezVous` object with updated details.
  - Response Body: Updated `RendezVous` object.

- `DELETE /api/rendezvous/{id}`
  - Description: Delete an appointment by ID.
  - Response Body: None (204 No Content).

### Employe Endpoints (`/api/employes`)

- `POST /api/employes`
  - Description: Create a new employee.
  - Request Body: `Employe` object.
  - Response Body: Created `Employe` object.

- `GET /api/employes`
  - Description: Get all employees.
  - Response Body: List of `Employe` objects.

- `GET /api/employes/{id}`
  - Description: Get an employee by ID.
  - Response Body: `Employe` object.

- `PUT /api/employes/{id}`
  - Description: Update an employee by ID.
  - Request Body: `Employe` object with updated details.
  - Response Body: Updated `Employe` object.

- `DELETE /api/employes/{id}`
  - Description: Delete an employee by ID.
  - Response Body: None (204 No Content).

### Stock Endpoints (`/api/stock`)

- `POST /api/stock`
  - Description: Add a new stock item.
  - Request Body: `Stock` object.
  - Response Body: Created `Stock` object.

- `GET /api/stock`
  - Description: Get all stock items.
  - Response Body: List of `Stock` objects.

- `GET /api/stock/{id}`
  - Description: Get a stock item by ID.
  - Response Body: `Stock` object.

- `PUT /api/stock/{id}`
  - Description: Update a stock item by ID.
  - Request Body: `Stock` object with updated details.
  - Response Body: Updated `Stock` object.

- `DELETE /api/stock/{id}`
  - Description: Delete a stock item by ID.
  - Response Body: None (204 No Content).

### Facture Endpoints (`/api/factures`)

- `POST /api/factures`
  - Description: Create a new invoice.
  - Request Body: `Facture` object.
  - Response Body: Created `Facture` object.

- `GET /api/factures`
  - Description: Get all invoices.
  - Response Body: List of `Facture` objects.

- `GET /api/factures/{id}`
  - Description: Get an invoice by ID.
  - Response Body: `Facture` object.

- `PUT /api/factures/{id}`
  - Description: Update an invoice by ID.
  - Request Body: `Facture` object with updated details.
  - Response Body: Updated `Facture` object.

- `DELETE /api/factures/{id}`
  - Description: Delete an invoice by ID.
  - Response Body: None (204 No Content).

This documentation provides a general overview of the API. Specific implementation details and validation rules would be found within the application's code.