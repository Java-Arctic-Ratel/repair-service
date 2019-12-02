# Install and Use PostgreSQL 

## Step 1 — Installing PostgreSQL

    sudo apt-get update
    sudo apt-get install postgresql-10 postgresql-contrib
    
## Step 2 — Using PostgreSQL Roles and Databases

    sudo -u postgres psql
    
## Step 3 — Creating a New Role  

    create user repair_admin with password 'repair123!';
    
## Step 4 — Creating a New Database

    create database repair_db;
    
## Step 5 - Assignment of rights

    grant all privileges on database repair_db to repair_admin;
    
## Step 6 - Exit the interactive Postgres session by typing

    \q
    
## Step 7 - Authentication and getting started with the database

    psql -h localhost repair_db repair_admin