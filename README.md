Description of the Java Banking Application
=========================================================================================================================================================================
•	This Java application implements a basic banking system using JDBC for database interactions. It includes multiple modules, each designed to handle specific
functionalities such as account creation, deposits, withdrawals, checking balances, and displaying user profiles. Below is an overview of the key components
and their responsibilities:
======================================================================================================
Package: com.java.dao
=====================================================================================================
Balance Class
-----------------------------------------------------------------------------------
•	Functionality: Checks the balance of a user by validating their name and mobile number.
Key Method:
-------------------------------------------------------------------------
•	checkBalance(): Queries the database for a user’s details and displays their balance along with associated information.
Withdraw Class
---------------------------------------------------------
•	Functionality: Facilitates withdrawal of funds by verifying user credentials and ensuring sufficient balance.
Key Method:
-----------------------------------------------------
•	withdrawAmount(): Validates the user’s name and ID, checks the balance, and updates the database with the new balance after a successful withdrawal.
o	Deposit Class
---------------------------------------------------------------------------------------
•	Functionality: Allows users to deposit money into their account after validating their credentials.
Key Methods:
-----------------------------------------------------------------------
•	depositAmount(): Prompts for deposit details, calculates the new balance, and updates it in the database.
•	getName(String name): Retrieves a user’s name from the database.
•	getMobileNumber(String mobileNumber): Retrieves a user’s mobile number from the database.
•	getBalance(String inputName): Fetches the current balance of a user by their name.
Profile Class
-------------------------------------------------------------------------
Functionality: Displays the complete profile of all users stored in the database.
Key Method:
-------------
•	getProfile(): Retrieves and prints all user records, including details like ID, name, mobile number, email, Aadhaar, PAN, address, and balance.
BankAccountOpening Class
------------------------
•	Functionality: Facilitates the creation of a new bank account by collecting user information and inserting it into the database.
Key Method:
----------------
•	openAcount(): Prompts the user for account details, validates the input, and creates a new record in the database.
Package: com.java.main
BankMain Class
-------------------------
•	Functionality: Acts as the entry point for the application, presenting a menu-driven interface for users to interact with various banking operations.
Key Features:
========================================================================
•Presents options to open an account, view all records, check balance, deposit money, withdraw money, and exit.
•	Uses a switch statement to invoke the appropriate methods from the com.java.dao package based on the user's choice.
•	Features
•	Account Management:
-----------------------------------------------------------------------
•	Create a new account with personal details and an initial deposit.
•	Balance Inquiry:
--------------------------------------------------
•	Check account balance by providing name and mobile number.
•	Deposit Funds:
------------------------------------------------------------
•	Add money to an account after verifying the user’s credentials.
•	Withdraw Funds:
----------------------------------------------------------------
•	Withdraw money with proper validation and balance checks.
•	View User Profiles:
-----------------------------------------------------------------------
•	Display all stored user records in the database for administrative purposes.
•	Menu Navigation:
-----------------------------------------------------------------------------
•	A simple menu-driven interface for easy user interaction.
•	Database Requirements
•	The application interacts with a database table named users1, which should have the following structure:
-------------------------------------------------------------------------------------------------------
sql
================================
CREATE TABLE users1 (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
mobileNumber VARCHAR(15) NOT NULL,
emailId VARCHAR(100),
adharNumber VARCHAR(20),
panNo VARCHAR(20),
passcode VARCHAR(6),
address VARCHAR(255),
balance DOUBLE NOT NULL
);

How to Use
=====================================
Run the BankMain class to start the application.
Use the menu options to perform operations:
1: Open a new account.
2: View all user profiles.
3: Check your balance.
4: Deposit funds into your account.
5: Withdraw funds from your account.
6: Exit the application




💳 Java Banking System Overview
This Java Banking System provides basic banking functionalities with a menu-driven interface:

1. Account Management 🏦
Account Opening: Create a new account by providing personal details (name, mobile, email, etc.) and an initial deposit. 📋💰
Profile Viewing: View user records, including ID, name, contact details, and balance. 🧐📊
2. Transactions 💵
Deposit: Add money to an account and update the balance. 💳💸
Withdrawal: Withdraw funds after validation and ensuring sufficient balance. 🏧🚶‍♂️
Balance Check: Check the current account balance. 💰🔍
3. Modular Design 🔧
Classes for Specific Tasks:
BankAccountOpening: Open a new account. 🆕
Deposit: Handle deposits. 💳
Withdraw: Handle withdrawals. 💸
Balance: Check balance. 💵
Profile: View user profiles. 👤
Database Interaction: SQL queries are used to interact with the users1 table. 🗄️💻
4. User Interface 📱
Console-Based Menu: A simple console-based menu to navigate through the system. 🖥️📑
Input Validation: Ensures valid user data and consistency. ✅
Database Table Structure 🗂️
A database table named users1 is used to store user information like:

sql
Copy code
CREATE TABLE users1 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    mobileNumber VARCHAR(15),
    emailId VARCHAR(100),
    adharNumber VARCHAR(20),
    panNo VARCHAR(20),
    passcode VARCHAR(6),
    address VARCHAR(255),
    balance DOUBLE NOT NULL
);
Potential Enhancements 🚀
Error Handling: Improve error reporting. ⚠️
Security: Encrypt sensitive information. 🔐
UI Improvements: Build a graphical interface (GUI). 🎨
Transaction History: Add a feature for transaction records. 📜
