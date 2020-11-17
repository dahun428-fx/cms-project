<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>내담C&C 경력관리 시스템</title>
	<!-- css -->
	<tiles:insertAttribute name="css" />
	<!-- script -->
	<tiles:insertAttribute name="script" />
</head>
<body>
<div class="ui fluid container">
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div class="navi">
		<tiles:insertAttribute name="navi" />
	</div>
	<div class="main">
		<div class="ui container" style="margin-top: 5rem; margin-bottom: 5rem;">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</div>
</body>
</html>