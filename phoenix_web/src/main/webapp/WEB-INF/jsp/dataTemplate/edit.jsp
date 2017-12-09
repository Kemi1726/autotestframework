<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>数据模板编辑</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/xheditor/xheditor-1.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/xheditor/xheditor_lang/zh-cn.js"></script>
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
</head>
<sf:form method="post" action="${dataTemplateBean.id }" modelAttribute="dataTemplateDTO">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">名称</td>
        <td><sf:input path="name" value="${dataTemplateBean.name}"/><sf:errors path="name"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">数据类型</td>
        <td>

            <sf:select path="type">
                <c:forEach items="${templateDataType}" var="cts">
                    <c:choose>
                        <c:when test="${cts.key eq  dataTemplateBean.type}">
                            <sf:option value="${dataTemplateBean.type }" selected="selected">${cts.value}</sf:option>
                        </c:when>
                        <c:otherwise>
                            <sf:option value="${cts.key }">${cts.value }</sf:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </sf:select>
            <sf:errors path="type"/>

        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">说明</td>
        <td><sf:input path="description" value="${dataTemplateBean.description}"/><sf:errors path="description"/></td>
    </tr>

    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary">提交</button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</sf:form>
<script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
			var localObj = window.location;
			var contextPath = localObj.pathname.split("/")[1];
			var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
			window.location.href=basePath+"/dataTemplate/list";
		 });

    });
</script>
</body>
</html>
