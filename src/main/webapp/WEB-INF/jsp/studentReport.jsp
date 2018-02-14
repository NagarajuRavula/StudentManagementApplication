<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href=${pageContext.request.contextPath}/css/studentReport.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<script type="text/javascript">
         var contextPath='<%=request.getContextPath()%>';
</script>


<script src=${pageContext.request.contextPath}/js/studentReport.js></script>
<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
<%@include file="adminHeader.jsp" %>
<center>
<div id="chartContainer_academicReport"></div>
<div id="chartContainer_attendenceReport"></div>
</center>
<%@include file="footer.jsp" %>
</body>
</html>