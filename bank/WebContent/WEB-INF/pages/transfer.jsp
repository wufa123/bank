<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录查询</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
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
    <div id="title" align="center"><h1>行内单笔转账</h1></div>
    <div align="center">
            <form action="transfer" method="post">
			<TABLE class="divTab" width="500">
            <TR>
                <TD colspan="2" align="center" style="font-size:25px;">
                    行内单笔转账清单
                </TD>
            </TR>
            <TR>
                <TD colspan="2" align="center" style="font-size:15px;color:red;">
                    ${msg}
                </TD>
            </TR>
            <TR>
                <TD align="right" width="35%">接收账号：</TD>
                <TD align="left" width="65%"><INPUT TYPE="text"  NAME="receive_account" ></TD>
            </TR>
            <TR>
                <TD align="right" width="35%">转账金额：</TD>
                <TD align="left" width="65%"><INPUT TYPE="text" NAME="receive_money" ></TD>
            </TR>
            <TR>
                <TD colspan="2" align="center" style="font-size:30px;">
                    <INPUT TYPE="submit" value="进行转账">
                    <INPUT TYPE="reset" value="取消操作">
                </TD>
            </TR>
            </TABLE>
            </form>
    </div>
</body>
</html>