# JavaEE

## How to use in IntelliJ ?

### Fast way

The `docs/idea` folder contains an example of runner and artifacts

Copy the `docs/idea` to your .idea

### Manually
First make sure you have a running TomCat Server.

Go to File -> Project Structure (CTRL + ALT + MAJ + S).

In project, select a SDK for the project 

![sdk][sdk]

Next step is to download the MySQL lib to the project on [MySQL website](https://dev.mysql.com/downloads/connector/j/)

Once you downloaded it, extract and copy the jar (ex: mysql-connector-java-5.1.46.jar) into the **lib** folder.

Then you will need to add it in IntelliJ as following

![mysql_library][mysql_library]

Create an artifact (*Web Application: Exploded*) and fill it as followed

![base-war-exploded][base-war-exploded]


In the end you will need to add a run option (based on *Tomcat Server -> Local*).

You will have a similar configuration to the following one.

![alt full_tomcat_run_conf][full_tomcat_run_conf]

Last step is how you want to implement MySQL parameters. With the `resources/config.properties` or the `web/web.xml` file

If you choose the `config.properties` way (easier to have a private file that will not be pushed on a repository), 
you will need to copy the `resources/config.properties.dist` to `resources/config.properties` and fill the parameters

If you choose the `web/web.xml` way, you will need to fill all the mysql_* parameters 
and extend the `servlet.AbstractContextServlet` class in all your Servlets, this way your Servlets will be properly 
configured to use the `web/web.xml` parameters

[sdk]: docs/img/SDK.png
[full_tomcat_run_conf]: docs/img/full_tomcat_run_conf.png
[base-war-exploded]: docs/img/base-war-exploded.png 
[mysql_library]: docs/img/mysql_library.png 
[]: 
