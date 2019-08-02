<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>行内单笔转账</title>
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
    <div id="title" align="center"><h1>行内单笔转账成功</h1></div>
    <div align="center">
        <table class="divTab" width="80%">
            
            <tr>
                <td colspan="2">
                    <br/>
                    <br/>
                    <span class="remaining"> 
                    ${msg}
                    </span>
                    <br/>
                    <br/>
                    <br/>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>