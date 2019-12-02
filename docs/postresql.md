# Install and Use PostgreSQL 

##Step 1 — Installing PostgreSQL
    sudo apt-get update
    sudo apt-get install postgresql postgresql-contrib
    
##Step 2 — Using PostgreSQL Roles and Databases
    sudo -u postgres psql
    
##Step 3 — Creating a New Role  
    create user user1 with password 'password123!';
    
##Step 4 — Creating a New Database
    create database database1;
    
##Step 5 - Assignment of rights
    grant all privileges on database database1 to user1;
    
##Step 6 - Exit the interactive Postgres session by typing
    \q
    
##Step 7 - Authentication and getting started with the database
    psql -h localhost database1 user1