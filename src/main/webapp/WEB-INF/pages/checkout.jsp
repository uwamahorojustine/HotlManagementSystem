<%@ include file="headerUser.jsp" %>

<h1>Reception</h1>
<h3><font color="black"><a href="checkin">Check-in<a>|<a href="checkout">Check-out<a></font></h3>
<h5><Bill</h5>
<table>
<tr>
<td>Booking No:</td><td>${booking.bookingId}</td></tr>
<tr><td>Customer Name:</td><td>${booking.names}</td></tr>
<tr><td>StartDate:</td><td>${booking.startDate}</td></tr>
<tr><td>EndDate:</td><td>${booking.checkOutDate}</td></tr>
<tr><td>Nights:</td><td>${booking.nights}</td></tr>
<tr><td>Room Id:</td><td>${booking.roomId}</td></tr>
<tr><td>Paid Amount:</td><td>${booking.amount}</td></tr>
<tr><td>:</td><td></td></tr>
<tr><td colapan="2">Thank you!</td></tr>




</tr>
</table>
<form action="printbookingbill"method="post">
<input type="hidden" name="bookingId" value="${booking.bookingId}">
<input type="submit" name"printbillbtn" value="Print Bill">
</form>
</font>
</body>
</html>