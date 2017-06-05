<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: binlix26
  Date: 4/06/17
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer.css">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <%-- need to associate this data with customer id when updating--%>
            <%-- very important to make setter for id. --%>
            <form:hidden path="id" />

            <table>
                <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                    <%--<td><form:errors cssClass="error" path="firstName"/></td>--%>
                </tr>

                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName"/></td>
                    <%--<td><form:errors path="lastName" cssClass="error"/></td>--%>
                </tr>

                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                    <%--<td><form:errors path="email" cssClass="error"/></td>--%>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear: both"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>

</body>
</html>
