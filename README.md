MPClub - Club Management System

Think of this project as a small digital clubhouse.
It doesn’t have all the bells and whistles of modern frameworks, but it shows how the classic Java web stack - Servlets, JSP, JDBC, and Tomcat - can come together to build something real.

What you can do here

- Register as a member with your details (name, email, program, year).

- Browse and add books to a simple catalog.

- Admin view to display, edit, or remove members.

- Error handling with a dedicated error page when things go wrong.

🛠 How it’s built

Backend → Java Servlets handling requests & business logic

Frontend → JSP pages + a touch of CSS for layout

Database → MySQL for members, text file storage for books

Testing → JUnit tests for database operations

Deployment → Runs on Apache Tomcat as a WAR file

🚀 Why it matters

This app was my way of understanding the nuts and bolts of Java web apps. Instead of relying on frameworks, it gets into the raw details: managing database connections, handling form submissions, forwarding requests, and stitching JSPs together.

It’s not just “yet another CRUD app” — it’s my hands-on attempt at wiring up the moving parts of a real web application.

▶️ How to run it

Clone the repo.

Create a MySQL database named memberdb (or adjust context.xml).

Deploy the project to Tomcat.

Open http://localhost:8080/MPClub
.

Pages to explore:

/MPRegister.jsp → Register a new member

/MPMemberAdmin?action=displayMembers → Manage members

/MPDisplayBooks → View the book catalog
