<%@ include file="headerUser.jsp" %>
<h2> USERS LIST </h2>

<table class="tableClass">
<tr>
    <th>User Id</th>
    <th>UserName</th>
    <th>Names</th>
    <th>Role</th>
    <th>Edit/Remove</th>
</tr>
<c:forEach items="${allusers}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.names}</td>
         <td>${user.role}</td>
         <td><a href="showEditUser?id=${user.id}&useName=${user.userName}&names=${user.names}&password=${user.password}">Edit</a>/<a href ="removeUser?id=${user.id}">Remove</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>