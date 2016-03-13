<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<style type="text/css">
		
			body{
				margin:0;
				padding:0;
				font-family: Sans-Serif;
				line-height: 1.5em;
			}
			#searchContainer{
				padding:20px;
			}
			main {
				padding-bottom: 10010px;
				margin-bottom: -10000px;
				float: left;
				width: 100%;
			}
			
			#nav {
				float: left;
				width: 230px;
				margin-left: -100%;
				padding-bottom: 10010px;
				margin-bottom: -10000px;
				background: #eee;
				height:1000px;
			}
			
			#wrapper {
				overflow: hidden;
			}
			
			#content {
				margin-left: 230px; /* Same as 'nav' width */
			}
			
			.innertube{
				margin: 15px; /* Padding for content */
				margin-top: 0;
			}
			
			p {
				color: #555;
			}
	
			nav ul {
				list-style-type: none;
				margin: 0;
				padding: 0;
			}
			
			nav ul a {
				color: gray;
				text-decoration: none;
			}
	
		</style>
		
	
	</head>
	
	<body>
		<div id="wrapper">
		
			<main>
				<div id="content">
					<div class="innertube">
						<h3>Search</h3>
						<div>
						<%@ include file="searchform.jsp" %>
						 </div>
						 <h3>Result(s)</h3>
						 ${keyword} 
						 <ul>
							<c:forEach var="row" items="${result}">
								<li> ${row} </li>
							</c:forEach>
							</ul>
					</div>
				</div>
			</main>
			
			<nav id="nav">
				<div class="innertube">
					<h3>Solr</h3>
					<ul>
						<li><a href="#">Index</a></li>
						<li><a href="#">Search</a></li>
						<li><a href="#">Browse</a></li>
					</ul>
				</div>
			</nav>
			
		</div>
	</body>
</html>
