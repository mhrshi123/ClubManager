
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Books</title>
    </head>
    <body>
        <jsp:include page="MPBanner.jsp"/>


        <div class="Books">
            <h2>List of Books</h2>
            <table>
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>Quantity</th>
                </tr>
                <c:forEach var="book" items="${requestScope.books}">

                    <tr>

                        <td>
                            <c:out value="${book.code}">

                            </c:out>
                        </td>
                        <td>
                            <c:out value="${book.description}">

                            </c:out>
                        </td>
                        <td>
                            <c:out value="${book.quantity}">

                            </c:out>
                        </td>
                    </tr>

                </c:forEach>

            </table>
        </div>
        <form id="addBookForm" action="MPAddBook.jsp" method="get">
            <input type="submit" value="Add Book" />
        </form>

        <jsp:include page="MPFooter.jsp" />

    </body>
</html>
