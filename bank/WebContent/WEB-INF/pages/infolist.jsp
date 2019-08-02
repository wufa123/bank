<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 在页面引入JSTL核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录查询</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
        【622600766401用户】，欢迎你登录XX银行个人网上银行系统！
    </div>
    <div id="menu" align="center"> 
        <div class="operateTitle">操作菜单<div>
        <span class="menu"><a href="login">个人首页</a></span>
        <span class="menu"><a href="remaining">账号余额查询</a></span>
        <span class="menu"><a href="info">交易记录查询</a></span>
        <span class="menu"><a href="transfer">行内单笔转账</a></span>
    </div>
    <div id="title" align="center"><h1>交易记录查询</h1></div>
    <div align="center">
         <table class="divTab" width="100%">
            <tr>
                <td><b>流水号</b></td>
                <td><b>交易类型</b></td>
				<td><b>交易金额</b></td>
                <td><b>交易时间</b></td>
                <td><b>交易摘要</b></td>
            </tr>
            <c:forEach var="item" items="${trades}">
            <tr>
                <td><b>${item.id}</b></td>
                <td><b>${item.tradeType}</b></td>
				<td><b>￥${item.tradeMoney}</b></td>
                <td><b>${item.tradeTime}</b></td>
                <td><b>${item.tradeDigest}</b></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>