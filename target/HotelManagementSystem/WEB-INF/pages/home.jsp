<%@ include file="header.jsp" %>

Rooms and prices
<div class="tableList">
<h2> ROOMS LIST </h2>
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
                 <td><a href="reservation?roomId=${room.roomId}">${room.status}</a>
                 <c:if test="${room.status != 'Available'}">

                         </c:if>
                          <c:if test="${room.status == 'Available'}">


                             </c:if>
                             </td>

    </tr>

</c:forEach>
</table>
</div>
</body>
</html>
