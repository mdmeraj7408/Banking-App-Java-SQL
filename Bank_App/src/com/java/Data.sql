Data base Table

  id             
 name            
 mobileNumber
 emailId      
 adharNumber  
 panNo        
 paasscode                    |
 address      
 balance
 
 CREATE TABLE users1 (
    userId INT AUTO_INCREMENT PRIMARY KEY,   -- Unique user ID, automatically incremented
    name VARCHAR(100) NOT NULL,              -- User's name
    mobileNumber VARCHAR(15) NOT NULL,       -- Mobile number
    emailId VARCHAR(100) NOT NULL,           -- Email address
    adharNumber VARCHAR(12) UNIQUE,          -- Aadhaar number (12 digits, unique)
    panNo VARCHAR(10) UNIQUE,                -- PAN number (10 characters, unique)
    passcode VARCHAR(50) NOT NULL,           -- Password or passcode
    address VARCHAR(255),                    -- User's address
    balance DECIMAL(15, 2) DEFAULT 0.00      -- Account balance, default is 0.00
);