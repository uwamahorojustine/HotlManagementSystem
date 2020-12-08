<%@ include file="header.jsp" %>
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
          <td><a href="addRoom?id=${room.id}$Description=${room.description}$Price=${room.price}$Status=${room.status}"></a></td>

    </tr>
</c:forEach>
</table>
</body>
</html>