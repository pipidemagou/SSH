<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>添加员工界面</title>
</head>
<body>

<s:form method="POST" action="user_addUser.action" theme="simple">

    <table align="center" border="1">
        <tr>
            <td>员工名称</td>
            <td><s:textfield name="username" id="username" value=""/></td>
        </tr>

        <tr>
            <td>员工部门</td>
            <!--
        Struts下拉列表标签：
            name="deptId"  下拉列表标签的名称(服务器根据这个名称获取选择的项的实际的值value值)
            headerKey   默认选择项的实际的值
            headerValue  默认下拉列表显示的内容
            list      下拉列表显示数据的集合
            listKey    集合对象的哪个属性作为下拉列表的实例的值，即value值
            listValue  集合对象的哪个属性作为下拉列表显示的值
            value      默认选择的项的设置
        -->
            <td><s:select list="#request.deptList" headerKey="-1" headerValue="请选择" listKey="id" listValue="name" name="deptId"/></td>
        </tr>
        <tr>
            <td colspan="2"><s:submit value="添加员工"/></td>
        </tr>
    </table>
</s:form>


</body>
</html>