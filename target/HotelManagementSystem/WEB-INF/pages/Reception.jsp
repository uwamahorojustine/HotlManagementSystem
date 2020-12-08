<%@ include file="headerUser.jsp" %>

<h1>Reception</h1>
<h3><font color="black"><a href="checkin">Check-in<a>|<a href="checkout">Check-out<a></font></h3>
<!--
<form action="addRoomAction" method="post">
<table>
<tr>
<td>description:</td>
<td><input type="text" name="description"></td>
</tr>
<tr>
<td>status:</td>
<td><input type="text" name="status"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" name="price"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Addroombtn" value="Add Room"></td>
</tr>
</table>
</form>
<hr />
<h2> ROOMS LIST </h2>
<table class="tableClass">
<tr>
    <th>Description </th>
    <th>Status</th>
    <th>Price</th>

</tr>
<c:forEach items="${allrooms}" var="room">
    <tr>
        <td>${user.description}</td>
        <td>${user.status}</td>
        <td>${user.price}</td>
    </tr>
</c:forEach>
</table>


-->




</body>
</html>