<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>修改员工界面</title>
</head>
<body>

<s:form method="POST" action="user_updateUser.action" theme="simple">

    <table align="center" border="1">

            <%--这里要把id通过隐藏域带过去--%>
        <s:hidden name="id" id="id" value="%{id}"/>
        <tr>
            <td>员工名称</td>
            <td><s:textfield name="username" id="username"/></td>
        </tr>

        <tr>
            <td>员工部门</td>
            <td>
                <s:select name="deptId"
                          list="#request.deptList"
                          listKey="id"
                          listValue="name"
                          value="dept.id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><s:submit value="修改员工"/></td>
        </tr>
    </table>
</s:form>

</body>
</html>