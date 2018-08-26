# SpringBootHealthApi
This an API Services written in Java using Spring Boot Framework and MySQL as its database.

# Requirement
Download java Version > v1.8 , Maven > v3.2
Download MySql Workbench

# Project Set Up

**Set Up MySql Database**
Run the files in the SqlScripts direectory
Ensure that the script run seperately **in order**
1. AccHealthCreate
2. AccHealthSchema
3. acc_health_user
4. acc_health_refs
5. acc_health_gen_doc_info
6. acc_health_general_booking_log

Clone the git repository using the following into your desire directory
```
git clone https://github.com/yemwl1994/SpringBootHealthApi.git
```
Enter into the project directory where the **pom.xml** is and run the maven command below to download the required package
```
mvn install
```

After Successfully installing the requried packages, you may start the app with
```
mvn spring-boot:run
```

# Notes
Ensure the database is set up on port 3306
The Application will run on the localhost with port 8888
URL Base and Context Path example : http://localhost:8888/accenture/healthcare/1.0.0/
