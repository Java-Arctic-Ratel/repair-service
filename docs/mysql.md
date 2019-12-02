# Install and Use MySQL 

## Step 1 — Installing MySQL

    sudo apt-get update
    sudo apt-get install mysql-server
    sudo mysql_secure_installation
    
## Step 2 — Using MySQL Roles and Databases

    sudo mysql -u root -p
        
## Step 3 — Creating a New Database

    CREATE DATABASE repair_db;
    
## Step 4 — Creating a New Role 

    CREATE USER 'repair_admin'@'localhost' IDENTIFIED BY 'repair123!';

## Step 5 — Assignment of rights  

    GRANT ALL ON repair_db.* TO 'repair_admin'@'localhost';
    
## Step 6 - Exit the interactive MySQL session by typing

    QUIT;
    
## Step 7 - Authentication and getting started with the database

    mysql -u repair_admin -p repair_db