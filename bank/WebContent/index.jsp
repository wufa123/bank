<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX银行个人网上银行系统</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="title" align="center">
		<h1>XXX银行个人网上银行系统</h1>
	</div>
	<div id="operation">
		<div id="link_student" align="center">
			<form action="${pageContext.request.contextPath}/login" method="post">
				<TABLE class="divTab" width="500">
					<TR>
						<TD colspan="2" align="center" style="font-size: 25px;">个人客户登录</TD>
					</TR>
					<TR>
						<TD colspan="2" align="center"
							style="font-size: 15px; color: red;">${msg}</TD>
					</TR>
					<TR>
						<TD align="right" width="35%">账号：</TD>
						<TD align="left" width="65%"><INPUT TYPE="text"
							NAME="account"></TD>
					</TR>
					<TR>
						<TD align="right" width="35%">密码：</TD>
						<TD align="left" width="65%"><INPUT TYPE="password"
							NAME="password"></TD>
					</TR>
					<TR>
						<TD colspan="2" align="center" style="font-size: 30px;"><INPUT
							TYPE="submit" value="提　　交"> <INPUT TYPE="reset"
							value="重　　置"></TD>
					</TR>
				</TABLE>
			</form>
		</div>
	</div>
</body>
</html>