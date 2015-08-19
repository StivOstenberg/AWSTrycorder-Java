<%-- 
    Document   : lastuserresponse
    Created on : Aug 4, 2015, 10:29:03 AM
    Author     : s.ostenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="com.stiv.AWSTrycorderPackage.TrycorderWS" />
        <jsp:setProperty name="mybean" property="lastuser"  />
        <h1>Last user:<jsp:getProperty name="mybean" property="lastuser" /> </h1>
    </body>
</html>
