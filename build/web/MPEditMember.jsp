<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Member</title>
    </head>
    <body>
        <%@ include file="MPBanner.jsp" %>
        <h1>Edit Member</h1>
        
          <% 
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <p style="color:red;"><%= message %></p>
            
        <% 
            } 
        %>
        
        
        <form action="MPMemberAdmin" method="post">
            <input type="hidden" name="action" value="saveMember">
            <label>Email:</label>
            <input type="email" name="email" value="${member.emailAddress}" readonly><br>
            <label>Full Name:</label>
            <input type="text" name="fullName" value="${member.fullName}" ><br>

            <label>Phone Number:</label>
            <input type="text" name="phoneNumber" value="${member.phoneNumber}" ><br>

            <label for="program">IT Program:</label>
            <select id="program" name="programName" value="${member.programName}" >
                <option value="CAS">CAS</option>
                <option value="SQATE">SQATE</option>
                <option value="CPA">CPA</option>
                <option value="CP">CP</option>
                <option value="ITID">ITID</option>
                <option value="CAD">CAD</option>
                <option value="ITSS">ITSS</option>
            </select>
            <br>

            <label for="year">Year Level:</label>
            <select id="year" name="yearLevel" value="${member.yearLevel}" >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <br>

            <button type="submit">Save</button>
            <button type="reset">Reset</button>
            <br>
        </form>
        <%@ include file="MPFooter.jsp" %>
    </body>
</html>
