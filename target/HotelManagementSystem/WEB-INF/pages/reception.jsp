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
<td><input type="text" name="othernames">
</td>
</tr>
<tr>
<td>Tel:</td>
<td><input type="text"name="Tel"></td>
</tr>
<tr>
<td>Room ID</td>
<td>
<select name="roomId">
<c:forEach  var="room" items="${availableRooms}">
<option value="${room.roomId}">${room.status}(${room.roomId})</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Start Date:</td><td><input type="text" name="startDate"</td>
</tr>
<tr>
<td>End Date:</td><td><input type="text" name="endDate"></td>
</tr>
<tr>
<td colspan=2><input type="submit"name="Ckeckin" value="Check-in"></td>
</tr>
</table>
</form>
<hr />




<h2>Ckeck Stutus</h2>
<form action="checkStatus" method="post">
Date from:<input type="text" name="dateFrom">
<input type="submit" name"checkbtn" value="Ckeck">
</form>
<h2> Room Bookings Information </h2>
<div class="tableList">
<table class="tableClass">
<tr><th>RoomId</th>
    <th>Description </th>
    <th>Price</th>
    <th>Booking</th>
    <th>More Info</th>
</tr>
<c:forEach items="${roomBookings}" var="room">
    <tr>
        <td>${room.key.roomId}</td>
        <td>${room.key.description}</td>
        <td>${room.key.price}</td>
        <td>
        <table>
        <c:forEach var="booking" items="${room.value}">
        <tr>
        <td>${booking.names}</td><td>${booking.startDate}-${booking.endDate}</td><td><a href="checkout?bookingId=${booking.bookingId}">Checkout</a></td>
        </tr>
        </c:forEach>
        </table>
        </td>
        <td></td>
        <td><a href="booking?roomId=${room.key.roomId}">More Info</a></td>
    </tr>

</c:forEach>

</table>
</div>

<h2> Room Reservation Information </h2>
<div class="tableList">
<table class="tableClass">
<tr><th>RoomId</th>
    <th>Description </th>
    <th>Price</th>
    <th>Reservation</th>
    <th>More Info</th>
</tr>
<c:forEach items="${roomReservations}" var="room">
    <tr>
        <td>${room.key.roomId}</td>
        <td>${room.key.description}</td>
        <td>${room.key.price}</td>
        <td>
        <table>
        <c:forEach var="reservation" items="${room.value}">
        <tr>
        <td>${reservation.names}</td><td>${reservation.startDate}-${reservation.endDate}</td>

        <td><a href="checkin?roomId=${reservation.roomId}">Checkin</a></td>
        </tr>
        </c:forEach>
        </table>
         </td>
        <td></td>
        <td><a href="reservation?roomId=${room.key.roomId}">More Info</a></td>
    </tr>

</c:forEach>
</table>
</div>
</body>
</html>