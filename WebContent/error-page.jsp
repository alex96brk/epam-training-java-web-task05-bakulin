<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style><%@ include file="/static/css/error-style.css"%></style>
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
                            	<p>Error Page</p> 
                        	</li>
                        	<li>
                      			<a class ="btn-main" href="./welcome">Back to Main</a>
                        	</li>
                    	</ul>
                    	<input type="hidden" name="command" id="command" value="file_upload">
                	</div>
                	<div class="description">
                		<h2>Application Error Prompts:</h2>
                		<ul>
                			<li>1) Check your xml file for correct data according xsd schema</li>
                			<li>2) Check your document for correct file type</li>
                			<li>3) Push Back to Main Menu and Try Again</li>
                		</ul>
                	</div>
                	<div class="description">
                		<h2>Error Description:</h2>
                		<ul>
                			<li>${errorMessage}</li>
                		</ul>
                	</div>
				</div>
			</div>
		</div>
</body>
</html>