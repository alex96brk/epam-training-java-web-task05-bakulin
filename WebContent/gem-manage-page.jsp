<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html/>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gem Manage Portal</title>
		<style><%@ include file="/static/css/style-static.css"%></style>
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
				<div class = "title">
					<h1>Gem Manage Portal</h1>
				</div>
				<div class="logo">
					<a href="https://training.by/">
						<img src='<c:url value="/static/img/epam-tc-img.png"></c:url>'/>
					</a>
				</div>
			</div>
			<div class="main">
				<div class="content">
					<div class="tool_bar">
                    	<ul>
                    		<li>
                            	<p>Parsed Gem Data:</p>
                        	</li>
                        	<li>
                            	<p>Parser Type: ${parserType}</p>
                        	</li>
                        	<li>
                      			<a class ="btn-main" href="./welcome">Back to Main</a>
                        	</li>
                    	</ul>
                	</div>
                	<div class = "gem_table">
                		<table id="gems"></table>
                	</div>
                	<div class="pagination" id="pagination"></div>
				</div>
			</div>
		</div>
		<script>
			let gems = ${gemsJson};
			<%@ include file="/static/js/index-pagination.js"%>
		</script>
	</body>
</html>