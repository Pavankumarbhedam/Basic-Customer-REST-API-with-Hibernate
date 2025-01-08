# Basic Customer REST API with Hibernate

This project demonstrates a basic implementation of a RESTful API for managing customer data using **Hibernate** and **JAX-RS**. It provides CRUD (Create, Read, Update, Delete) operations for `Customer` entities and uses a MySQL database as the data store.

## Features

- **REST API**: Provides endpoints for CRUD operations.
- **Hibernate ORM**: Used for object-relational mapping with MySQL.
- **XML and JSON Support**: API responses and requests support both JSON and XML formats.
- **Layered Architecture**: Includes resource, service, and repository layers for better modularity and maintainability.

---

## Technologies Used

- **Java**: Programming language for backend development.
- **JAX-RS**: For building RESTful web services.
- **Hibernate**: ORM framework for interacting with the MySQL database.
- **MySQL**: Relational database for data persistence.
- **Maven**: For dependency management and project build.

---

## Project Structure

```plaintext
src/
└── main/
    ├── java/
    │   └── com.pavan.DemoRestApi/
    │       ├── Customer.java       # Entity class for customer
    │       ├── CustomerResource.java  # REST API endpoints
    │       └── CustomerRepository.java  # Data access layer
    └── resources/
        ├── hibernate.cfg.xml       # Hibernate configuration file
        └── WEB-INF/
            └── web.xml             # Deployment descriptor
```

---

## Endpoints

### **GET** `/customers`
Returns a list of all customers.

- **Response Format**: JSON/XML

---

### **GET** `/customers/{id}`
Returns a specific customer by ID.

- **Path Parameter**: `id` (integer)
- **Response Format**: JSON/XML

---

### **POST** `/customers/posting`
Adds a new customer to the database.

- **Request Body**: Customer object in JSON/XML.
- **Response**: The newly created customer.

---

### **PUT** `/customers/update`
Updates an existing customer's details.

- **Request Body**: Updated customer object in JSON/XML.
- **Response**: The updated customer.

---

### **DELETE** `/customers/delete/{id}`
Deletes a customer by ID.

- **Path Parameter**: `id` (integer)
- **Response**: The deleted customer object (or `null` if not found).

---

## Database Configuration

The database connection is configured in `hibernate.cfg.xml`:

```xml
<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/RestApi</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">1618</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
<property name="hibernate.hbm2ddl.auto">update</property>
<property name="hibernate.show_sql">true</property>
```

- **Database Name**: `RestApi`
- **Username**: `root`
- **Password**: `1618`

---

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/Pavankumarbhedam/Basic-Customer-REST-API-with-Hibernate.git
   ```

2. Import the project into your IDE (e.g., Eclipse or IntelliJ IDEA).

3. Configure your MySQL database:
   - Create a database named `RestApi`.
   - Update the credentials in `hibernate.cfg.xml` if necessary.

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Deploy the application:
   - Use a server like **Tomcat** or **Jetty**.

6. Test the endpoints using tools like **Postman** or **cURL**.

---

## Example Customer Object

### JSON Format
```json
{
  "cid": 1,
  "cName": "John Doe",
  "designation": "Manager",
  "salary": 75000
}
```

### XML Format
```xml
<Customer>
  <cid>1</cid>
  <cName>John Doe</cName>
  <designation>Manager</designation>
  <salary>75000</salary>
</Customer>
```

---
