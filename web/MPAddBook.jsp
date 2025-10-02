<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <jsp:include page="MPBanner.jsp" />
        <h2 class="page-title">Add a New Book</h2>

        <div class="errors">
            <c:if test="${not empty errors}">
                <ul style="color: red;">
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                        </c:forEach>
                </ul>
            </c:if>
        </div>
        <form action="MPAddBook" method="post">

            <div class="form-container">
                <label for="code">Code:</label>
                <input type="text" id="code" name="code" value="${code}" />
            </div>
            <br/>

            <div class="form-container">

                <label for="description">Description:</label>
                <input type="text" id="description" name="description" value="${description}" />

            </div>
            <br/>


            <div class="form-container">
                <label for="quantity">Quantity:</label>
                <input type="text" id="quantity" name="quantity" value="${quantity}" />

            </div>
            <br/>


            <div class="form-container">
                <input class="button-save" type="submit" value="Save" />
                <input class="button-cancel" type="submit" value="Cancel" formaction="MPDisplayBooks" formmethod="get" />
            </div>
        </form>
        <jsp:include page="MPFooter.jsp" />
    </body>
</html>