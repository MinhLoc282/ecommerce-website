# eCommerce Website

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![Apache](https://img.shields.io/badge/apache-%23D42029.svg?style=for-the-badge&logo=apache&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![hibernate](https://img.shields.io/badge/hibernate-%20brightgreen.svg?&style=for-the-badge&logo=hibernate&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![junit](https://img.shields.io/badge/junit-%20yellowgreen.svg?&style=for-the-badge&logo=junit&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

<br>

![GitHub contributors](https://img.shields.io/github/contributors/phuongnt-git/ecommerce-website)
![GitHub issues](https://img.shields.io/github/issues/phuongnt-git/ecommerce-website?color=red)
![GitHub top language](https://img.shields.io/github/languages/top/phuongnt-git/ecommerce-website?color=cyan)
![GitHub repo size](https://img.shields.io/github/repo-size/phuongnt-git/ecommerce-website)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/phuongnt-git/ecommerce-website)
![Github total lines](https://sloc.xyz/github/phuongnt-git/ecommerce-website)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/phuongnt-git/ecommerce-website?color=g)
![GitHub last commit](https://img.shields.io/github/last-commit/phuongnt-git/ecommerce-website?color=yellow)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/phuongnt-git/ecommerce-website)

<br>
<br>

## Overview

- Technical: **JSP** (**J**akarta **S**erver **P**ages) and **Servlet**
  - [**Java Servlet API 4.0.1**](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/4.0.1)
  - [**JavaServer Pages(TM) API 2.3.3**](https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api)
  - [**JSTL 1.2**](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)
  - [**JavaMail API 1.6.2**](https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.6.2)
- Build: **Maven Project 4.0.0**
- [**Apache Tomcat® 9.x**](https://tomcat.apache.org/download-90.cgi)
- Relational database management system: [**MySQL Connector Java 8.0.31**](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.31)
- Hibernate's core ORM functionality: [**Hibernate 5.4.33.Final**](https://mvnrepository.com/artifact/org.hibernate/hibernate-core/6.1.5.Final)
- Integration for c3p0 Connection pooling into Hibernate ORM: [**Hibernate C3P0 Relocation 5.6.14.Final**](https://mvnrepository.com/artifact/org.hibernate/hibernate-c3p0/5.6.14.Final)

- Testing framework:
  - JUnit Jupiter is the API for writing tests using JUnit 5: [**JUnit Jupiter API 5.9.1**](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1)
  - Core package for the JUnit Jupiter test engine: [**JUnit Jupiter Engine 5.9.1**](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.9.1)

- PayPal SDK for integrating with the REST APIs: [**REST API SDK 1.14.0**](https://mvnrepository.com/artifact/com.paypal.sdk/rest-api-sdk/1.14.0)


- Frontend frameworks :
  - [**Bootstrap 5.2.x**](https://getbootstrap.com/) - Powerful, extensible, and feature-packed frontend toolkit.
  - [**jQuery 3.3.1**](https://jquery.com/) - jQuery is a fast, small, and feature-rich JavaScript library.
  - [**AJAX**]() (**A**synchronous **J**avaScript **a**nd **X**ML) - send and retrieve data from a server
      asynchronously without interfering with the display and behaviour of the existing page.

- Design pattern : **M**odel - **V**iew - **C**ontroller (**MVC**), **D**ata **A**ccess **O**bject (**DAO**)
- Integrated development environment (IDE) : **Eclipse IDE 2022**

<br>
<br>

## Project Structure

<pre>
<b>eCommerceWebsite</b>
├── db
│   ├── dumps                         (Generate the logical backup of the MySQL database)
│   ├── CreateDatabaseScript.sql      (Script MYSQL create database)
├── src
│   ├── main
│   │   ├── <b>java</b>
│   │   │   ├── <b>com.ecommerce.controller</b>
│   │   │   │   └── <b>com.ecommerce.controller.admin</b>     (Controller for admin page)
│   │   │   │   │   └── category                              (Contains navigation servlets for category module)
│   │   │   │   │   └── customer                              (Contains navigation servlets for customer module)
│   │   │   │   │   └── email                                 (Contains navigation servlets for email module)
│   │   │   │   │   └── order                                 (Contains navigation servlets for order module)
│   │   │   │   │   └── product                               (Contains navigation servlets for product module)
│   │   │   │   │   └── review                                (Contains navigation servlets for review module)
│   │   │   │   │   └── user                                  (Contains navigation servlets for user module)
│   │   │   │   └── <b>com.ecommerce.controller.filter</b>    (Contains filters that check access from specific URLs.)
│   │   │   │   └── <b>com.ecommerce.controller.shop</b>      (Controller for shop page)
│   │   │   │   │   └── cart                                  (Contains navigation servlets for cart module)
│   │   │   │   │   └── customer                              (Contains navigation servlets for customer module)
│   │   │   │   │   └── order                                 (Contains navigation servlets for order module)
│   │   │   │   │   └── payment                               (Contains navigation servlets for payment module)
│   │   │   │   │   └── product                               (Contains navigation servlets for product module)
│   │   │   │   │   └── review                                (Contains navigation servlets for review module)
│   │   │   ├── <b>com.ecommerce.service</b>                  (Handle business logic for controller)
│   │   │   ├── <b>com.ecommerce.model</b>
│   │   │   │   └── dao                                       (Consists of Entity access classes)
│   │   │   │   └── enity                                     (Classes for connecting to databases)
│   │   │   ├── <b>com.ecommerce.utility</b>                  (For common extracted method)
│   │   │   ├── <b>META-INF</b>
│   │   │   │   └── <a href="./eCommerceWebsite/src/main/java/META-INF/persistence.xml" target="_blank">persistence.xml</a>   (Configure a given JPA Persistence Unit)
│   │   ├── <b>test</b>
│   │   │   ├── <b>com.ecommerce.hibernate</b>                (Contains all of Hibernate's reverse entity classes)
│   │   │   ├── <b>com.ecommerce.model</b>                    (Contains JUnit Test Case for model classes)
│   │   │   ├── <b>com.ecommerce.model.dao</b>                (Contains JUnit Test Case for DAO classes)
│   │   │   ├── <b>com.ecommerce.utility</b>                  (Contains test class for common utility class)
│   │   ├── <b>webapp</b>
│   │   │   ├── <b>META-INF</b>
│   │   │   │   └── <a href="./eCommerceWebsite/src/main/webapp/META-INF/hibernate.cfg.xml" target="_blank">hibernate.cfg.xml</a>   (Configure a hibernate)
│   │   │   ├── <b>WEB-INF</b>
│   │   │   │   └─── <a href="./eCommerceWebsite/src/main/webapp/WEB-INF/web.xml" target="_blank">web.xml</a>
│   │   │   ├── <b>assets</b>
│   │   │   │   └── bootstrap
│   │   │   │   └── css
│   │   │   │   └── fonts
│   │   │   │   └── img                         (Images)
│   │   │   │   └── js                          (Custom javascript and jQuery)
│   │   │   │   └── sass
│   │   │   │   └── scss
│   │   │   ├── <b>admin</b>                    (Contain jsp files for admin's user interface)
│   │   │   ├── <b>shop</b>                     (Contain jsp files for shop's user interface)
│   │   │   ├── <b>error</b>                    (Contain jsp files for friendly error's user interface)
├── <a href="./eCommerceWebsite/pom.xml" target="_blank">pom.xml</a>    (Acronym for Project Object Model)
</pre>

<br>
<br>

<!-- # How to run

1. Download [Eclipse Installer](https://www.eclipse.org/downloads/packages/) and setup Eclipse IDE for Enterprise Java and Web Developers.
2. Download and setup [MySQL Community Server](https://dev.mysql.com/downloads/mysql/) and [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).
3. Download this repo.
4. Execute CreateDatabaseScript.sql.
5. MySQL Workbench -> Server -> Data Import -> Import from Dump Project Folder -> ... -> Select Database Objects to Import -> Start Import.
6. Eclipse -> File -> Open Projects from File System... -> Directory... -> "Choose the path of this repo folder" -> Finish.
7. Wait for Maven setup and download all neccessary .jar from pom.xml.
8. Restart Eclipse.
9. Setup [Apache Tomcat](https://tomcat.apache.org/).
10. Click eCommerceWebsite -> Run As -> Run on Server -> Setup and enjoy ☺️ . -->

## Note

1. Change the connection (user and password) to MySQL in <a href="./eCommerceWebsite/src/main/java/META-INF/persistence.xml" target="_blank">persistence.xml</a> and <a href="./eCommerceWebsite/src/main/webapp/META-INF/hibernate.cfg.xml" target="_blank">hibernate.cfg.xml</a> to your local connection.
2. Password field of user and customer is encrypted by MD5. Use this for login:

- For user: admin@gmail.com | admin
- For customer: customer@gmail.com | customer

3. Set environment variables in <a href="./eCommerceWebsite/src/main/webapp/WEB-INF/web.xml" target="_blank">web.xml</a> for SMTP mail before run.

|Variables       |Require |Description                                                                               |Default         |
|----------------|--------|------------------------------------------------------------------------------------------|----------------|
|SMTP_HOST       |❌     |The SMTP server to connect to                                                             |smtp.gmail.com  |
|SMTP_PORT       |❌     |The SMTP server port to connect to, if the connect() method doesn't explicitly specify one|25/587         |
|SMTP_USER       |✔      |Username for SMTP Authenticator                                                           |                |
|SMTP_PASSWORD   |✔      |Password for SMTP Authenticator                                                           |                |
