<%@ include file="headerUser.jsp" %>

<h1>Reception</h1>

<h1><font color="black">

   <c:if test="${ role == 'restaurantManager'}">
   <a href="addItem">Add Item<a>|
    </c:if>

<a href="sellItem">Sell Item<a>|<a href="sellItemRoom">Room<a></font></h1>
<h2>Restaurant Available Items</h2>



<table class="tableClass">
<tr><th>Item ID</th>
    <th>Name </th>

    <th>Sell Price</th>

</tr>
   <c:forEach items="${allItems}" var="item">
              <tr>
                  <td>${item.itemId}</td>
                    <td>${item.name}</td>

                      <td>${item.sellPrice}</td>

                      </tr>

</c:forEach>



</div>
</body>
</html>