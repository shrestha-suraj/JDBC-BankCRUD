# JDBC-BankCRUD

In this application, we generalize the concept of JDBC by creating a virtual bank datbase with different entities.
The project is entirely written in Java. The final product is a console program that can perfrom CRUD opreation on
the database with the client class file. The dataase used in this application is MySQL, however any other SQL database 
can be used assuming that the credentials are providede to the end user and the the database driver jar file is imported 
in the library.

## Step by step guide to run the program
> Clone the project repository to your computer and run it on your faviourite IDE. (Eclipse or Intellij Recommended)
> If you are running the project for mysql server, there is a drivere already present in the lib folder.
> In case of other database, you can download the driver to the lib folder and import the classpath in the project.
> Inside the src/com/bank/ create a new java class called Connection.java and provide following code:

  <pre><code>
  class Connection{
    static final String URL="url_string_for_db_connection";
    static final String username="username_for_the_database";
    static final String password="password_for_the_database";
  }
  
</code></pre>

> All set! Run the main method from src/com/bank/client and make changes to the database.
