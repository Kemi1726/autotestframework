<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>单接口数据批次数据列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

    </style>
    <script>
        $(function () {
            $('#addnew').click(function(){
                var caseId = $("#batchId").val();
                var localObj = window.location;
                var contextPath = localObj.pathname.split("/")[1];
                var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
                window.location.href=basePath+"/dataTemplate/field/"+caseId+"/add";
            });
        });

        function del(id)
        {
            if(confirm("确定要删除吗？"))
            {
                var url = "index.jsp";
                window.location.href=url;
            }

        }
    </script>
</head>
<body>
<form class="form-inline definewidth m20" action="index.jsp" method="get">
    <button type="button" class="btn btn-success" id="addnew">新增数据</button>&nbsp;&nbsp;
    <%--<button type="button" class="btn btn-success" id="btnimport">导入数据</button>&nbsp;&nbsp;--%>
    <a href="<%=request.getContextPath()%>/dataTemplate/list">返回数据模板列表</a>&nbsp;&nbsp;
</form>
<input id="batchId" type="hidden" value="${dataTemplateBean.id}">
<table class="table table-bordered table-hover definewidth m10" >
    <tbody>
    <tr>
        <th class="tableleft" colspan="4">数据模板名字：${dataTemplateBean.name} &nbsp;&nbsp;&nbsp;ID：${dataTemplateBean.id }
        </th>
    </tr>
    <tr>
        <td>ID</td>
        <td>数值</td>
        <td>测试类型</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${dataTemplateBean.dataTemplateFieldBeans }" var="iids">
        <tr>
            <td>${iids.id }</td>
            <td>${iids.dataContent }</td>
            <td>${iids.testType }</td>
            <td><a href="<%=request.getContextPath()%>/dataTemplate/field/${dataTemplateBean.id}/delete/${iids.id }">删除</a>
                <a href="<%=request.getContextPath()%>/dataTemplate/field/${dataTemplateBean.id}/update/${iids.id }">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
