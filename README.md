# Furniture Ordering Website
---
### Team Members: Țoncu Ion, Cotorobai Vlad

## General Description:

This website's main goal is helping clients, designers and companies by offering the possibility to choose
a certain piece of furniture modeled by a desired designer and provided by a picked-out company.

## Registration(for all users, Imean Designers, Companies and Customers)

* The user needs to first register into the website by selection one of the 3 roles: customers, company,
designer. Any of the users require a unique username, and password.
* They will also add general information, like company name, email address, depending on the user.

## Company:

* After the company manager logs in, he can add or delete designers or the items
(projects)on his profile.
* Also, after logging on website, he will see his profile and list of items, customers
and designers.
* From profile, he will receive notifications and the manager will respond and in
case the company can serve customers, the designer will receive notification the
order.

## Designer:

* After the designer logs on website, he can add or delete projects.
* Also, he can see list of his projects or companies. He can also edit his project or
his profile (NAME, EMAIL, ETC.).
* After logging, he will see the list of notification from companies if customers will
order the furniture designed by this designer.

## Customer:

* A customer needs to login into the website where he will see a list with all the
projects.
* Also, after login, he can filter product by type or sort by price.
* When the customers will choose the products, he will be able to add or delete the
products, in case he chose a product from the designer, he will also choose the
company that will serve him, and a request will be sent to that company, and the
company will respond back to the customer, if it can serve him

## Site run specifications:

* Build Spring Boot Project with Maven
To be able to run your Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.
> maven package
or you can also use
> mvn install

* Run Spring Boot app with java -jar command
To run your Spring Boot app from a command line in a Terminal window you can you the java -jar command. This is provided your Spring Boot app was packaged as an executable jar file.

> java -jar target/com.fow.jar

* Run Spring Boot app using Maven
You can also use Maven plugin to run your Spring Boot app. Use the below example to run your Spring Boot app with Maven plugin:
> mvn spring-boot:run
---
## Use Case UML DIAGRAM:
![image](https://user-images.githubusercontent.com/69470698/118040741-9f01a800-b37a-11eb-8d23-e2b00b31fa44.png)

