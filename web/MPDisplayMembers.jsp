<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Member List</title>
    </head>
    <body>
        <%@ include file="MPBanner.jsp" %>
        <h1>Member List</h1>

        <!-- Display Members Table -->
        <table border="1">
            <tr>
                <th>Email</th>
                <th>Full Name</th>
                <th>Phone Number</th>
                <th>Program Name</th>
                <th>Year Level</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.emailAddress}</td>
                    <td>${member.fullName}</td>
                    <td>${member.phoneNumber}</td>
                    <td>${member.programName}</td>

                    <td>${member.yearLevel}</td>

                    <td>
                        <a href="MPMemberAdmin?action=editMember&email=${member.emailAddress}">Edit</a> |
                        <a href="MPMemberAdmin?action=removeMember&email=${member.emailAddress}">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <a href="MPMemberAdmin?action=addMember">Add New Member</a>
        <br>
        <a href="MPAdmin.jsp">Return to Admin</a>

        <%@ include file="MPFooter.jsp" %>
    </body>
</html>
