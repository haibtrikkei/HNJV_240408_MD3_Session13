<%--
  Created by IntelliJ IDEA.
  User: bthai
  Date: 7/29/2024
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Insert employees</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>INSERT EMPLOYEES</h1>
        <h3 class="text-dander">${error}</h3>

        <form action="insertEmployee" method="post">
            <table class="table table-bordered">
                <tr>
                    <td>Full name: </td>
                    <td><input type="text" name="fullName"/></td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td><input type="radio" name="gender" value="true"/>male
                        <input type="radio" name="gender" value="false"/>female</td>
                </tr>
                <tr>
                    <td>Birthday: </td>
                    <td><input type="date" name="birthday"/></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><textarea name="address"></textarea></td>
                </tr>
                <tr>
                    <td>Department: </td>
                    <td>
                        <select name="depId">
                            <option value="">------- chọn -------</option>
                            <c:forEach items="${listDepart}" var="d">
                                <option value="${d.depId}">${d.depName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="insert">
                        <input type="reset" value="clear">
                    </td>
                </tr>
            </table>
        </form>
        <a href="index.jsp">Back</a>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
