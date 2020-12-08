<%@ include file="headerUser.jsp" %>

<h1>Add Item</h1>
<form action="addItemAction" method="post">
<table>
<tr>
<td>Name:</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>buy Price:</td>
<td><input type="text" name="buyPrice" ></td>
</tr>
<tr>
<td>sell price</td>
<td><input type="text" name="sellPrice"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="AddItembtn" value="Add Item"></td>
</tr>
</table>
</form>
<hr />
<h2> Restaurant Items </h2>
<div class="tableList">
<table class="tableClass">
<tr>
        <th>Item Id </th>
        <th>Name </th>
        <th> buy Price</th>
         <th> sell Price</th>
          <th>Edit/Delete</th>

          <c:forEach items="${allItems}" var="item">
              <tr>
                  <td>${item.itemId}</td>
                    <td>${item.name}</td>
                      <td>${item.buyPrice}</td>
                      <td>${item.sellPrice}</td>


<td><a href ="showeditItem?itemId=${item.itemId}&name=${item.name}&buyPrice=${item.buyPrice}&sellPrice=${item.sellPrice}">Edit</a>/<a href="removeItem?id=${Item.ItemId}">Remove</a></td></td>

</c:forEach>
</tr>


</table>


</div>




</body>
</html>