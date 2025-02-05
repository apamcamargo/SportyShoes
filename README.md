# Sporty Shoes

## Table of Contents

- [Tools](#tools)
- [How to Run the Application](#how-to-run-the-application)
- [Application Navigation](#application-navigation)
  - [Registration](#registration)
  - [Admin](#admin)
  - [Home Page](#home-page)
  - [Categories](#categories)
  - [Add Products](#add-products)
  - [Order Details](#order-details)
  - [User](#user)
- [GitHub Repository](#github-repository)

## Tools

This project was developed using the following tools and technologies:

- Spring Initializer (for project generation)
- Java 17
- Spring Boot:
  - Starter Data JPA
  - Starter Security
  - Starter Thymeleaf
  - Starter Web
- MySQL
- Spring Security
- Eclipse

## How to Run the Application

### Add MySQL Credentials

To configure the MySQL database, follow these steps:

1. Open the `application.properties` file located in `src/main/resources`
2. Set your MySQL credentials:

   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Run the Application

To start the application, execute the `SportyShoesApplication.java` class.

---

## Application Navigation

### Registration

1. Start the application and go to [http://localhost:8080/login](http://localhost:8080/login)
2. Click on the **Register Here** button
3. Fill in the fields: First Name, Last Name, Email, Password, and select between **Admin** or **User**
4. Click the **Register** button
5. A success message will be displayed
6. Click on the **Login Here** link and log in with your credentials

### Admin

#### Home Page

1. Log in as an admin user
2. You will be redirected to the admin home page

#### Categories

- **Create a Category:**
  - Click on **Categories** in the menu
  - Click **Add Category**
  - Enter the category name and submit

- **Update a Category:**
  - Click the **Update** button next to the category
  - Modify the name and submit

- **Delete a Category:**
  - Click the **Delete** button next to the category

#### Add Products

1. Click on **Add Product** in the menu
2. Fill in:
   - Product ID (PId)
   - Product Name (PName)
   - Price
   - Select the category
3. Click **Store Product**

#### Update a Product

1. Click the **Update** button on the product you want to modify
2. Modify the details and click **Update**

#### Delete a Product

1. Click the **Trash** icon next to the product
2. The product will be deleted

#### Place an Order

1. Click the **Cart** icon next to the product you want to buy
2. A success message will be displayed

### Order Details

To check order details:

1. Click on **Orders** in the menu
2. All placed orders will be displayed

### User

1. Click **Logout**
2. Navigate to [http://localhost:8080/login](http://localhost:8080/login)
3. Log in with a regular user account
4. The user home page will be displayed
5. Click on **Shop**, choose a product, and click the **Cart** button
6. The product has been successfully purchased

---

## GitHub Repository

Find the source code at: [Sporty Shoes Repository](https://github.com/apamcamargo/SportyShoes)

