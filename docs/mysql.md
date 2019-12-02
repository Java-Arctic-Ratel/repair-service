# Install and Use MySQL 

##Step 1 — Installing MySQL
    sudo apt-get update
    sudo apt-get install mysql-server
    sudo mysql_secure_installation
    
##Step 2 — Using MySQL Roles and Databases
    mysql -u root -p
        
##Step 3 — Creating a New Database
    CREATE DATABASE database2;
    
##Step 4 — Creating a New Role and Assignment of rights  
    GRANT ALL ON database2.* TO 'user2' IDENTIFIED BY 'password123!';
    
##Step 5 - Exit the interactive MySQL session by typing
    QUIT;
    
##Step 6 - Authentication and getting started with the database
    mysql -u user2 -p database2