<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/Js/jquery-1.7.2.js"></script>
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
<sf:form method="post" action="" modelAttribute="dataTemplateFieldDTO">
<table class="table table-bordered table-hover definewidth m10">
    <input id="dataTemplateId" type="hidden" value="${dataTemplateBean.id} ">

    <tr>
        <td width="10%" class="tableleft">模板名字</td>
        <td>
        	${dataTemplateBean.name }
        </td>
    </tr>

    <%--<tr>--%>
        <%--<td width="10%" class="tableleft">参数名</td>--%>
        <%--<td><sf:input id="dataName" path="dataName"/></td>--%>
        <%--</tr>  --%>
    <tr>
    <td width="10%" class="tableleft">数值</td>
    <td><sf:input id="dataContent" path="dataContent"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">测试类型</td>
        <td>
            <sf:select path="testType">
                <c:forEach items="${dataTemplateFieldTestType}" var="cts">
                    <sf:option value="${cts.key }">${cts.value }</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="testType"/>
        </td>
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
			window.location.href=basePath+"/dataTemplate/field/"+ ${dataTemplateBean.id} +"/list";
		 });

    });
</script>
</body>
</html>