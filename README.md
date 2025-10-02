MPClub - Club Management System

This project started as a way to learn Java web development using Servlets, JSP, and JDBC, and it grew into a small but functional club management portal. It’s not trying to be a big production system — it’s a hands-on project that shows how the moving pieces of a Java web app come together.

What it does

Lets new members register with details like name, email, phone, program, and year.

Provides an admin view to display, edit, or remove members.

Keeps track of a small book catalog (add books, display books, update quantities).

Uses MySQL (via JDBC connection pooling) for member data and a simple text file for books.

How it’s built

Backend: Java Servlets + JDBC for database access

Frontend: JSP pages with basic CSS and shared templates (banner, footer)

Database: MySQL (with option to plug in H2 for testing)

Testing: JUnit tests for the data layer

Server: Runs on Apache Tomcat (classic WAR deployment)

Why it’s interesting

This project is a nice snapshot of “classic” Java EE-style development: JSPs for views, Servlets for controllers, and JDBC for persistence. It forced me to think about request handling, error pages, database connections, and how to make code a little less messy with a simple MVC-ish structure.

How to try it

Clone the repo and open it in NetBeans/IntelliJ (it has Ant build scripts).

Set up a MySQL database called memberdb (you can change this in context.xml).

Deploy the WAR to Tomcat.

Visit http://localhost:8080/MPClub and explore:

/MPRegister.jsp → register a new member

/MPMemberAdmin?action=displayMembers → manage members

/MPDisplayBooks → view the book catalog
