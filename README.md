# Student Management System Using Hibernet
This is a Student Management System made Using Hibernet Framework

-----

##### 1st Step 
Create a Maven Project

** How to create Maven Project **

* Go to file 
* New 
* Select Maven Project 
* Check the Simple project 
* Give file location 
* Click on Next 
* Give GroupId which is package name 
* Give ArtifactId which is Project Name 
* Finish

*If got any error in the Maven Project*

* Right click on the Maven Project 
* Click on Maven 
* Update 
* Check the checkbox of force update
* Next

##### 2nd Step

Add the Persistence code in the pom.xml file within dependencies tag.

** How to add the persistence code **

* Search [Maven Repository](https://mvnrepository.com/) 
* Then search for **Mysql Connector** and click on the result with high usages 
* Click on the version with high usage 
* Copy the dependency codes 
* Add to the pom.xml file.
* Then search for **Hibernate core** and click on the result with high usages 
* Click on the version with high usage 
* Copy the dependency codes 
* Add to the pom.xml file.

		<dependencies>
	 <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>8.0.28</version>
		</dependency>
	<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
		    <groupId>org.hibernate</groupId>
		    <artifactId>hibernate-core</artifactId>
		    <version>5.6.15.Final</version>
		</dependency>
  		</dependencies>
  
##### 3rd Step

* Create a folder inside the subdirectory of src/main/resources named **'META-INF'**.
* Create a file inside that folder named **'persistence.xml'**.
* Add these persistence code written down in that file with proper table name,path name, password.


	 	<?xml version="1.0" encoding="UTF-8"?><persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
	  http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd" version="2.1">
		<persistence-unit name="Dev">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<shared-cache-mode>ENABLE_SELECTIVE</shared-cache-mode>      <!-- for caching -->  
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url"  value="jdbc:mysql://localhost:3306/schema_name" />
			<property name="javax.persistence.jdbc.user" value="user_name" />
			<property name="javax.persistence.jdbc.password" value="password" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
		</properties>
		</persistence-unit>
		</persistence>

##### 4th Step

Create packages for -
1. **DTO (Data Transfer Object)** - In hibernet the meaning of the object is nothing but entity, entity is nothing but table.
2. **DAO (Data Access Object)** - In DAO all the data will be received or access from the DTO. 
3. **Controller**  - Controller mainly used to do the configuration.Controller will play the role of main method, inside it we will declare the main method.


* Inside controller we will create object for DTO to establish the connection between controller & DTO.
* Inside controller we will create object for DAO to establish the connection between controller & DAO.
  

##### Final Step

Start writing the codes for different packages.

* **DTO Package**

This package will used to create the table directly in the database.
* The class name will be the table name, we have to add **@Entity** before the class name first.
* To create primary key **@Id** have to be used before the variable name
* To create column inside the table **@Column** have to be added before the variable name, if we have to add some constrain like unique or null we have to add we have to add nullable = false to make the column as not null like that  .Then to make getter and setter we have to make the use of **getter()** and **setter()** method.

 
		@Entity
		public class Student 
		{
		@Id
		int student_id ;
		
		@Column(nullable = false)
		String student_name ;
		
		@Column(nullable = false, unique = true)
		String student_contact;
		
		@Column(nullable = false)
		int student_class;
		public int getStudent_id() {
			return student_id;
		}
		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}
		}
	
	
* **DAO PACKAGE** 

This package will contain all the logical and main condition for the program.

	
		EntityManagerFactory entityManagerFatory = Persistence.createEntityManagerFactory("Dev");
		EntityManager entityManager	= entityManagerFatory.createEntityManager();
		EntityTransaction entityTransaction	= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(reference_variable);
		entityTransaction.commit();
		
Persistance is a java class which implements different interface.They are - 
* *EntityManagerFactory Interface* - This Interface have a abstract static method named **createEntityManager()**.


* *EntityManager Interface* - This Interface have several abstract non-static method like -  
	**createEntityManager()** , <br>
	**persist()** which is used to save the data,<br>
**merge()** which is used to update the data ,<br>
**find()** which is used to fetch the details based on id, <br>
**createQuery()** which is used to fetch complete table information in a single sort,<br>
**remove()** it is used to remove any particular data based on id.


* *EntityTransaction Interface* - This Interface have several abstract non-static method like -  
**getTransation()** which is used to affect the table i.e, inserting,updating,deleting some data from the table, that's why in case of data fetching it is not needed,
**begin()** before performing any operation like edit,update, delete, we have to call these method.<br>
**commit()** after performing all the operation in the end we have to call these method.


* *Query Interface* - This Interface have several abstract non-static method like -  
**getResultList()** which is used to store list of data that have been fetched from db. <br>
**executeUpdate()** which is used to modify multiple data in the db in single sort.


   ![Hierarhy](image/Hibernate hierarchy.drawio.png)




* ** CONTROLLER PACKAGE**

This package will control the total program, according to the user choice it will invoke the Dao package and run the program.
 

