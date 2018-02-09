<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Iuuses</title>





<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/studentIssues.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src=${pageContext.request.contextPath}/js/studentIssues.js>
	</script>
<!-- this script is used to initialize the context path	 -->
<script type="text/javascript">
         var contextPath='<%=request.getContextPath()%>';
	</script>



	
<!-- 	files needed for styling of data table&js files -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">	
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>



<!-- libs for tab -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>







<body>
<%@include file="header.jsp" %>
 <h3 id="title">Student Issues</h3>
 
 <div class="container">
  <ul class="nav nav-pills" id="list">
    <li class="active"><a data-toggle="pill" href="#pending_issues" onclick="pendingIssues();" >Pending Issues</a></li>
    <li><a data-toggle="pill" href="#resolved_issues" onclick="resolvedIssues();" >Resolved Issues</a></li>
    <li><a data-toggle="pill" href="#ignored_issues" onclick="ignoredIssues();" >Ignored Issues</a></li>
  </ul>
  
  <div class="tab-content">
    <div id="pending_issues" class="tab-pane fade in active"> 
    </div>
    <div id="resolved_issues" class="tab-pane fade">
    </div>
    <div id="ignored_issues" class="tab-pane fade">
    </div>
  </div>
</div>










<%@include file="footer.jsp" %>
</body>
</html>