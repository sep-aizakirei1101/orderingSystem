<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang=“ja”>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
</head>
<title>注文ページ</title>
<style>
body {
Meiryo, メイリオ, sans-serif;
	background: #FFD5EC;
}
</style>
</head>
<body>
	<h2>パーツを注文します。 下記に注文数を入力してください。</h2>

	<form:form modelAttribute="FormModel" action="/system/kakunin" >
		<p>
			部品A <input type="text" name="PartsA" size="2">個<br>
		</p>
		<p>
			部品B <input type="text" name="PartsB" size="2">個<br>
		</p>
		<p>
			部品C <input type="text" name="PartsC" size="2">個<br>
		</p>
		<p>
			部品D <input type="text" name="PartsD" size="2">個<br>
		</p>
		<p>
			部品E <input type="text" name="PartsE" size="2">個<br>
		</p>
		<p>
			日付 2016年 <input
				type="text" name="Month" size="2">月 <input type="text"
				name="Day" size="2">日
		</p>
		<P>
			注文担当者名 <input type="text" name="Odname" size="16">
		</p>
		<Div Align="right">
			<button type="submit" value="send">発注する</button>
		</Div>
	</form:form>
	<Div Align="right">
		<input type="button" value="トップに戻る"
			onclick="location ='http://localhost:8080/system/toppage2'" />
	</Div>
</body>
</html>
