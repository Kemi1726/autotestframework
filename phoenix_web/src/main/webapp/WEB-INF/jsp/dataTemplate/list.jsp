<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用例数据模板列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap-responsive.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/layer/layer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/TableSort.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
            font-family:Courier New,Microsoft YaHei;
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
<form class="form-inline definewidth m20" action="select" method="get">  
    数据模板名称：
    <input type="text" name="keyWord" id="keyWord" class="abc input-default" placeholder="支持模糊查询..." value="${keyWord }"/>
    &nbsp;&nbsp; <button type="submit" class="btn btn-primary">查询</button>
    &nbsp;&nbsp;<button type="button" class="btn btn-success" onClick="$.tools.add('<%=request.getContextPath()%>/dataTemplate/add');">新增数据模板</button>
</form>
<table id="tblist" class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr role="head">
        <th width="7%" sort="true">
        <button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-sort"></span> Sort
        </button>
        </th>
        <th>名称</th>
        <th>数据类型</th>
        <th>说明</th>
        <th>管理操作</th>
    </tr>
    </thead>
    <tbody>
       <c:forEach items="${datas.datas}" var="ss">
	     <tr>
            <td>${ss.id }</td>
            <td><a href="update/${ss.id}" title="编辑数据模板">${ss.name }</a>
            <td>${ss.type }</td>
            <td>${ss.description }</td>
            <td>
                  <a href="update/${ss.id}"><span class="label label-primary"><span class="glyphicon glyphicon-edit"></span>&nbsp;编辑数据模板</span></a>&nbsp;&nbsp;
                  <a href="field/${ss.id}/list"><span class="label label-warning"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;数据</span></a>
                  <a href="javascript:$.alerts.delconfirm('delete/${ss.id}');"><span class="label label-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除数据模板</span></a>&nbsp;&nbsp;
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