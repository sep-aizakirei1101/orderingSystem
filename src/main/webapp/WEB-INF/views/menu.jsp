<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu</title>
</head>
<Div Align="center">
	<h2>MENU</h2>
</Div>
<body bgcolor="#99ff99">


		<form action ="http://localhost:8080/system/hoge" target="main" method=post>
			<br>
		<input type="submit" value="発注登録"><br> <br></form>
		<form action ="http://localhost:8080/system/hoga" target="main" method=post>
			<br>
		<input type="submit" value="進捗確認"><br> <br></form>
		<form action ="http://localhost:8080/system/partsod" target="main" method=GET>
			<br>
		<input type="submit" value="部品注文"><br> <br></form>
		<form action ="http://localhost:8080/system/hogi" target="main" method=post>
			<br>
		<input type="submit" value="発送準備"><br> <br></form>


</body>
</html>