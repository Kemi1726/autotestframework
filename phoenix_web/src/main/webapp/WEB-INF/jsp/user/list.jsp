<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户信息列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/layer/layer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/TableSort.js"></script>

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
</head>
<body>
<form class="form-inline definewidth m20" action="index.jsp" method="get">  
<button type="button" class="btn btn-success"  onClick="$.tools.add('<%=request.getContextPath()%>/user/add');" >添加新用户</button>
</form>
<table id="tblist" class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr role="head">
        <th width="7%" sort="true">
        <button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-sort"></span> Sort
        </button>
        </th>
        <th>用户名称</th>
        <th>用户角色</th>
        <th>用户昵称</th>
        <th>用户邮箱</th>
        <th>创建日期</th>
        <th>管理操作</th>
    </tr>
    </thead>
    <tbody>
       <c:forEach items="${datas.datas}" var="us">
	     <tr>
            <td>${us.id }</td>
            <td>${us.username }</td>
            <td>${us.roleName }</td>
            <td>${us.nickname }</td>
            <td>${us.email }</td>
            <td><fmt:formatDate value="${us.createDate }" pattern="yyyy-MM-dd HH:mm:ss" ></fmt:formatDate></td>
            <td>
                  <a href="<%=request.getContextPath()%>/user/update/${us.id}"><span class="label label-primary"><span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</span></a>&nbsp;&nbsp;
                  <a href="javascript:$.alerts.delconfirm('<%=request.getContextPath()%>/user/delete/${us.id}');"><span class="label label-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</span></a>&nbsp;&nbsp;
            </td>
        </tr>
        </c:forEach>
        </tbody>
     </table>
<div class="inline pull-right page">
		<jsp:include page="/jsp/pager.jsp">
			<jsp:param value="${datas.total }" name="totalRecord"/>
			<jsp:param value="list" name="url"/>
		</jsp:include>
 </div>
<script>
    $(function () {
        $("#tblist").sorttable();
    });
</script>       
</body>
</html>
