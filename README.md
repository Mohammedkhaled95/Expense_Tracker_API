# Expense_Tracker_API


This is a Spring Boot Rest API project
Spring Modules used :
    Spring Core,Web 
    Spring Boot
    Spring Security
    Spring Data JPA,Hibernate
    
I used MySQL Database    

About Project:
  the Database have 3 tables represent the main three entities (User, Category, Transaction)
  for the user : I have endpoints to Register new user , Authenticate the user 
                 user password is hashed stored in db using Bcrybt password-hashing function
                 when user use authenticate endpoint : it returns a Token generated Automatically By JWT
                 
 for other Entities : there is endpoints to all CRUD Operation                
                 
