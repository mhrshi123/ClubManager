<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Remove Member</title>
    </head>
    <body>
        <%@ include file="MPBanner.jsp" %>
        <h1>Remove Member</h1>
        <p>Are you sure you want to remove this member?</p>
        <p>Email: ${member.emailAddress}</p>
        <p>Full Name: ${member.fullName}</p>

        <p>Phone: ${member.phoneNumber}</p>
        <p>IT Program: ${member.programName}</p>
        <p>Year Level: ${member.yearLevel}</p>


        <form action="MPMemberAdmin" method="post">
            <input type="hidden" name="action" value="deleteMember">
            <input type="hidden" name="email" value="${member.emailAddress}">
            <button type="submit">Yes, Remove</button>
            <a href="MPMemberAdmin?action=displayMembers">No, Cancel</a>
        </form>
        <%@ include file="MPFooter.jsp" %>
    </body>
</html>
