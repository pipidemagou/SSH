<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>列表展示</title>
</head>
<body>
<s:if test="#session.admin !=null">
    欢迎您：<s:property value="%{#session.admin.username}"/>
</s:if>
<s:a href="register.jsp">注册</s:a>
<s:a href="login.jsp">登陆</s:a>
<s:a href="user_viewAdd.action">添加员工</s:a>
<s:if test="#request.list != null">
    <table align="center" border="1">
        <tr>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>员工部门编号</td>
            <td>操作</td>
        </tr>

        <s:iterator var="user" value="#request.list" status="st">
            <tr>
                <td><s:property value="#user.id"/></td>
                <td><s:property value="#user.username"/></td>
                <td><s:property value="#user.dept.id"/></td>
                <td>
                    <s:a href="user_viewUpdate?id=%{#user.id}">修改</s:a>
                    <s:a href="user_delete?id=%{#user.id}"> 删除</s:a>
                </td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<s:else>对不起，还没有员工的信息，请录入</s:else>
</body>
</html>