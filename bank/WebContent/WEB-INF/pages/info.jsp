<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录查询</title>
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.12.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/laydate/laydate.js"></script>
</head>
<body>
	<div>
        【${user.accountId}用户】，欢迎你登录XX银行个人网上银行系统！
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
            <form action="${pageContext.request.contextPath}/info" method="post">
			<TABLE class="divTab" width="500">
            <TR>
                <TD colspan="2" align="center" style="font-size:25px;">
                    请选择查询交易时段
                </TD>
            </TR>
            <TR>
                <TD colspan="2" align="center" style="font-size:15px;color:red;">
                    请输入正确的查询时段！
                </TD>
            </TR>
            <TR>
                <TD align="right" width="35%">开始时间：</TD>
                <TD align="left" width="65%"><INPUT TYPE="text" placeholder="请输入日期" NAME="start_time" onclick="laydate()"></TD>
            </TR>
            <TR>
                <TD align="right" width="35%">结束时间：</TD>
                <TD align="left" width="65%"><INPUT TYPE="text" placeholder="请输入日期" NAME="end_time" onclick="laydate()"></TD>
            </TR>
			<TR>
				<TD colspan="2">*本查询仅能查询自当前时间起一个月内的业务</TD>
            </TR>
            <TR>
                <TD colspan="2" align="center" style="font-size:30px;">
                    <INPUT TYPE="submit" value="查看交易明细">
                    <INPUT TYPE="reset" value="取消操作">
                </TD>
            </TR>
            </TABLE>
            </form>
    </div>
</body>
</html>