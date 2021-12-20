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
			</div>
			<div class="sidebar">
				<div class="logo">
					<a href="https://training.by/">
						<img src='<c:url value="/static/img/epam-tc-img.png"></c:url>'/>
					</a>
				</div>
				<div class="navigation">
					<ul>
						<li>
							<h2 class="nav_link"><a>Parser Setup:</a></h2>
						</li>
						<li>
							<select class="select-parser">
								<option>DOM Parser</option>
								<option>SAX Parser</option>
								<option>StAX Parser</option>
							</select>
						</li>
					</ul>
				</div>
			</div>
			<div class="main">
				<div class="content">
					<div class="tool_bar">
						<form action="parse" method="post">
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
                        		<div class="submit-input">
                        			<input type="submit" id="submit" class="submit" value="Parse">
                        		</div>
                        	</li>
                    	</ul>
                    	</form>
                	</div>
                	<div class = "gem_table">
                		<table id="gems"></table>
                	</div>
                	<div class="pagination" id="pagination"></div>
				</div>
			</div>
		</div>
		<script>
			<%@ include file="/static/js/index-dynamic-select.js"%>
			let gems = ${gemsJson}
		</script>
		<script><%@ include file="/static/js/index-pagination.js"%></script>
	</body>
</html>