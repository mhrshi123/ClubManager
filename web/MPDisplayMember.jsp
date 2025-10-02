<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%@ include file="MPBanner.jsp" %>
        <section>
            <h1>Member Details</h1>
            <p>Full Name: ${param.fullname}</p>
            <p>Email: ${param.email}</p>
            <p>Phone: ${param.phone}</p>
            <p>IT Program: ${param.program}</p>
            <p>Year: ${param.year}</p>
            <form action="MPRegister.jsp" method="GET">
                <button type="submit">Return</button>
            </form>
        </section>
        <%@ include file="MPFooter.jsp" %>
    </body>
</html>
