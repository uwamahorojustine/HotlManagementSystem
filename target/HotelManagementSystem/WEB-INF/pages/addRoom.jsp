<%@ include file="headerUser.jsp" %>

<h1>Add Room</h1>
<form action="addRoomAction" method="post">
<table>
<tr>
<td>description:</td>
<td><input type="text" name="description"></td>
</tr>
<tr>
<td>status:</td>
<td><input type="text" name="status" value="Available"readOnly="true"></td>
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
<div class="tableList">
<table class="tableClass">
<tr>
        <th>Room Id </th>
        <th>Description </th>
        <th>Price</th>
        <th>Status</th>
</tr>
<c:forEach items="${allrooms}" var="room">
    <tr>
        <td>${room.roomId}</td>
                 <td>${room.description}</td>
                <td>${room.price}</td>
                 <td><c:if test="${room.status != 'Available'}">
                   ${room.status}
                    </c:if>
                   <c:if test="${room.status == 'Available'}">
                    <a href="reservation">${room.status}</a>
                    </c:if></td>

    </tr>
</c:forEach>
</table>


</div>




</body>
</html>