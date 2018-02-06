<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href=${pageContext.request.contextPath}/css/studentIssues.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>


<!-- libs for tab -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body>
<script type="text/javascript">
         var contextPath='<%=request.getContextPath()%>';
</script>


<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<%@include file="header.jsp" %>
 <h3 id="title">Student Issues</h3>
 <div class="container">
  <ul class="nav nav-pills">
    <li class="active"><a data-toggle="pill" href="#home">Pending Issues</a></li>
    <li><a data-toggle="pill" href="#menu1">Resolved Issues</a></li>
    <li><a data-toggle="pill" href="#menu2">Rejected Issues</a></li>
  </ul>
  
  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    </div>
    <div id="menu1" class="tab-pane fade">
    </div>
    <div id="menu2" class="tab-pane fade">
    </div>
    <div id="menu3" class="tab-pane fade">
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>