<%@ include file="headerUser.jsp" %>

<h1>Reception</h1>

<h1><font color="black">
<a href="checkin">Check-in<a>|<a href="checkout">Check-out<a></font></h1>
<h2>Check-In Form</h2>
<form action="checkinAction" method= "post">
<table>
<tr>
<td>Names:</td><td>
<select name="names">
<option value="">select names</option>
<c:forEach var="reservation" items="${pendingReservations}">
<option value="${reservation.names}">${reservation.names}</option>
</c:forEach>
</select>
<td>othernames:</td><td><input type="text" name="othernames"</td>
</td>
</tr>
<tr>
<td>Tel:</td>
<td><input type="text"name="Tel"></td>
</tr>
<tr>
<td>Room ID</td>
<td>
<select name="room">
<c:forEach items="${availableRooms}" var="room">
<option value="${room.roomId}">${room.roomId}(${room.status})</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Start Date:</td><td><input type="text" name="startDate"</td>
</tr>
<tr>
<td>End Date:</td><td><input type="text" name="endDate"</td>
</tr>
<tr>
<td colspan=2><input type="submit"name="Ckeckin" value="Check-in"></td>
</tr>
</table>    <td></td>
</form>
<hr />




<h2> ROOMS LIST </h2>
<div class="tableList">
<table class="tableClass">
<tr><th>RoomId</th>
    <th>Description </th>
    <th>Price</th>
    <th>Status</th>
</tr>
<c:forEach items="${rooms}" var="room">
    <tr>
    <td>${room.roomId}</td>
        <td>${room.description}</td>
        <td>${room.price}</td>
        <td><a href="reservation?roomId=${room.roomId}">${room.status}</td>
    </tr>

</c:forEach>
</table>
</div>






</body>
</html>