<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gem Portal</title>
		<style><%@ include file="/static/css/index-style.css"%></style>
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
						<form action="/parse" method="post">
                    	<ul>
                    		<li>
                            	<p>Choose xml file to parse</p>
                        	</li>
                        	<li>
                        		<div class="file-input">
                        			<input type="file" id="file" class="file">
            						<label for="file">
              							<p class="file-name">Select file</p>
            						</label>
                        		</div>	
                        	</li>
                        	<li>
								<select class="select-parser">
									<option>DOM Parser</option>
									<option>SAX Parser</option>
									<option>StAX Parser</option>
								</select>
						</li>
                        	<li>
                        		<div class="submit-input">
                        			<input type="submit" id="submit" class="submit" value="Parse">
                        		</div>
                        	</li>
                    	</ul>
                    	</form>
                	</div>
                	<div class="description">
                		<h2>Application Prompts:</h2>
                		<ul>
                			<li>1) Upload XML File with Gems data, click on Select File</li>
                			<li>2) Choose parse method in select options (DOM, SAX, StAX)</li>
                			<li>3) Submit changes, click on Parse Button and go</li>
                		</ul>
                	</div>
                	<div class="description">
                		<h2>Application Tech Core:</h2>
                		<ul>
                			<li>Server Side: Java EE, Servlet API, JSP</li>
                			<li>Servlet Container / Server: Apache Tomcat</li>
                			<li>User Interface: HTML5, CSS (Grid, Flexbox), JavaScript</li>
                			<li>Patterns: SOLID, Command, Abstract Factory</li>
                		</ul>
                	</div>
				</div>
			</div>
		</div>
		<script>
			<%@ include file="/static/js/index-dynamic-select.js"%>
		</script>
	</body>
</html>