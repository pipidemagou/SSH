<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>

<s:form action="admin_login" method="POST" theme="simple">
    <table border="1" align="center">
        <tr>
            <td>管理员账号：</td>
            <td><s:textfield name="username" value=""/></td>
        </tr>
        <tr>
            <td>管理员密码：</td>
            <td><s:textfield name="password" value=""/></td>
        </tr>

        <tr>
            <td colspan="2"><s:submit value="登陆"/> </td>
        </tr>
    </table>
</s:form>

</body>
</html>