<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%@ include file="MPBanner.jsp"%>
        <div id="linkDisplayBooks" >
            <a href="MPDisplayBooks">Maintain Books</a><br>
            <a href="MPMemberAdmin?action=displayMembers">Display Members</a>

        </div>
        <%@ include file="MPFooter.jsp" %>
    </body>
</html>
