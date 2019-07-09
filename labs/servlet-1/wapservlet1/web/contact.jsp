<%--
  Created by IntelliJ IDEA.
  User: ismail
  Date: 7/9/2019
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact us</title>
</head>
<body>
    <form action="contact" method="post">
        <p>
            Name: <input type="text" name="name">
        </p>
        <p>
            Email address: <input type="email" name="email">
        </p>
        <p>
            Problem: <input type="text" name="problem">
        </p>
        <p>
            Problem description: <textarea name="problem_desc" cols="30" rows="10"></textarea>
        </p>
        <p>
           <input type="submit" value="help">
        </p>
    </form>

<p>
    <b>
        <%= request.getAttribute("msg") %>
    </b>
</p>
</body>
</html>
