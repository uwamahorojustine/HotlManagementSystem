<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:if test="${userId == null}">
<c:redirect url="/"/>
</c:if>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-color: #ddd;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.tableClass {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

.tableClass td, .tableClass th {
  border: 1px solid #ddd;
  padding: 8px;
}

.tableClass tr:nth-child(even){background-color: #f2f2f2;}

.tableClass tr:hover {background-color: #ddd;}

.tableClass th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
.tableList{
width: 100%;
height:300px;
border:1px dotted black;
overflow: scroll;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="homeUser">Home</a>
  <a href="user">Add User</a>
  <a href="Room">Add room</a>
    <c:if test="${role == 'restaurant'|| role == 'restaurantManager'}">

  <a href="reception">Reception</a>
  <a href="report">Report</a>

    <a href="restaurant">Restaurant</a>
    </c:if>
    <a href="logout">Log out</a>
  <div align="right">
  <c:if test="${Izina != null}">
        Logged as: ${Izina}
        </c:if>
        </div>

</div>

