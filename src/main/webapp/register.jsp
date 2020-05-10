<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>

<s:form action="admin_register" method="POST" theme="simple">
    <table border="1" align="center">
        <tr>
            <td>管理员账号：</td>
            <td><s:textfield name="username"/></td>
        </tr>
        <tr>
            <td>管理员密码：</td>
            <td><s:textfield name="password"/></td>
        </tr>

        <tr>
            <td colspan="2"><s:submit value="注册"/> </td>
        </tr>
    </table>
</s:form>

</body>
</html>