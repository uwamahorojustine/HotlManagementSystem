<%@ include file="headerUser.jsp" %>

<h1>Add User</h1>
<form action="addUser" method="post">
<table>
<tr>
<td>Names:</td>
<td><input type="text" name="names"></td>
</tr>
<tr>
<td>User Name:</td>
<td><input type="text" name="userName"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>Role:</td>
<td><input type="text" name="role"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Adduserbtn" value="Add User"></td>
</tr>
</table>
</form>
</body>
</html>