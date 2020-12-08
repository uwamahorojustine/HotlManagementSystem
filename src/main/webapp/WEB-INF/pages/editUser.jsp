<%@ include file="headerUser.jsp" %>

<h1>Edit User</h1>
<form action="editUser" method="post">
<table>
<tr>
<td>Names:</td>
<td>
<input type="hidden" name="id" value="${userId}">
<input type="text" name="names" value="${names}"></td>
</tr>
<tr>
<td>User Name:</td>
<td>
<input type="text" name="userName" value="${useName}"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="text" name="password" value="${password}"></td>
</tr>
<td>Role:</td>
<td><input type="text" name="role" value="${role}"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Edituserbtn" value="Update User"></td>
</tr>
</table>
</form>
</body>
</html>