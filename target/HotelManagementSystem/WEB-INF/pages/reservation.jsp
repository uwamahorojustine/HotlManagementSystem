<%@ include file="header.jsp" %>

<h1>Reception</h1>
<form action="reservation" method="post">
<table>
<tr>

<tr>
<td>names:</td>
<input type="hidden" name="roomId" value="${roomId}"/>
<td><input type="text" name="names"></td>
</tr>
<tr>
<td>Tel</td>
<td><input type="text" name="tel"></td>
</tr>
<td>email</td>
<td><input type="text" name="email"></td>
</tr>
<td>startDate</td>
<td><input type="date" name="startDate"></td>
</tr>
<td>endDate</td>
<td><input type="date" name="endDate"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" name="Reservationbtn" value="Reservation"></td>
</tr>
</table>
</form>








</body>
</html>