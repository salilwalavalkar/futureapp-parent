Build Date: May 2013

------------------------------------------
Eclipse + Maven 2 + Spring 3 + Hiberate 3
------------------------------------------

Details: This sample project shows the basic flow of a Maven 2 + Spring + Hiberate project. It has all CRUD operations defined with transactions. 
Please note HSQL db is used for this example. The project futureapp-parent is the uppermost project with other projects as its modules. You can clean and build its pom.xml for any changes. This is not an ideal project structure but rather just an example of how the architechture can be layered and dependencies between them.

futureapp-parent
- futureapp-base
- futureapp-model
- futureapp-dao
- futureapp-service
- futureapp-web

In case you have difficulty in knowing which files are used, search with HASHTAG in the project. For example if you want to know approx the files for 

HSQL Setup and Queries:
/docs/HSQL_Setup.txt

URL Syntax: 
http://server:port/futureapp-web

URL Example:
http://localhost:8080/futureapp-web

#Contents
1. Spring (Bean + MVC + Annotations + Transaction) 		#SPRING
2. Hibernate (Annotations + Entity + EVO) 				#HIBERNATE
3. JQuery
4. Context Listener 									#CONTEXTLISTENER
5. Exception Handler 									#EXCEPTIONHANDLER
6. Logging SLF4j with Log4j 							#LOGGING
7. Aspect AOP 											#ASPECT
8. Custom Tag Library 									#CUSTOMTAGLIBRARY
9. HSQL In memory data db								#HSQL
10. Maven2
 

