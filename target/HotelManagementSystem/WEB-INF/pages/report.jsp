<%@ include file="headerUser.jsp" %>
<title>report</title>
</head>
<body>

<h1><font color="black">Run Report</font></h1>
<form action ="reportAction" method="post">
<font color="black">
StartDate:<input type="text" name="StartDate">
EndDate:<input type="text" name="EndDate">
Data:<select name="dataType">
<option value="booking">Booking</option>
<option value="reservation">Reservation</option>
</select>
<input type="submit" name="run" value="Run Report">
</form>
<hr>
<c:if test="${bookings.size()> 0}">
<form action="printBookingReport"method="post">
<input type="submit"name="printBookingReportbtn" value="Print Report">
</form>
<table>
<tr>
<td><Booking No</td>
<td>Names</td>
<td>Checkin Date</td>
<td>Checkout Date</td>
<td>Nights</td>
<td>Paid amount</td>
 <c:forEach var="booking" items="${bookings}">
<tr>
<td>${Booking.bookingId}</td>
<td>${booking.names}</td>
<td>${booking.startDate}</td>
<td>${booking.checkOutDate}</td>
<td>${booking.nights}</td>
<td>${booking.amount}</td>

</tr>
</c:forEach>
 </c:if>

</table>
</font>
</body>
</html>