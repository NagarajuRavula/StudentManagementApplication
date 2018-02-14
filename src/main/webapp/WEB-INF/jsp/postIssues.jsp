<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Post</title>





<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/postIssues.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src=${pageContext.request.contextPath}/js/postIssues.js>
	</script>
<!-- this script is used to initialize the context path	 -->
<script type="text/javascript">
         var contextPath='<%=request.getContextPath()%>';
	</script>


<!--  library for toastr -->
<!-- <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script> -->
<!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">



	
<!-- 	files needed for styling of data table&js files -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">	
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>



<!-- libs for tab -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  

</head>







<body>
<% Student user=(Student)session.getAttribute("loggedInUser");%>
<%@include file="studentHeader.jsp" %>

 <h3 id="title">Post Issues</h3>
 
 <div class="container">
 
<input type="hidden" id="id" name="id" value='<%=user.getId()%>' > 

 	<ul class="nav nav-pills" id="list">
    	<li class="active"><a data-toggle="pill" href="#new_issue" >New Issue</a></li>
    	<li><a data-toggle="pill" href="#issue_list" onclick="issueList()" >Issue List</a></li>
    </ul>
  
  	<div class="tab-content">
    	<div id="new_issue" class="tab-pane fade in active"> 
     		<center>
 				<form onsubmit="return saveIssue()" id="issue_form">
 
				 <p>Please select preferred issue type:</p>
 				 <div>
    				<input type="radio" id="issueChoice1"
     				name="issueType" value="Exam" required>
    				<label for="issueChoice1">Exam</label>

    				<input type="radio" id="issueChoice2"
     				name="issueType" value="Academic" required>
    				<label for="issueChoice2">Academic</label>
   
  				</div>
  
 					<textarea rows="6" cols="50" placeholder="Type upto 255 characters.." id="text_area" name="textArea" maxlength="255" required></textarea><br>
 					<input type="submit" id="post"  class="btn btn-success" value="Post">
 				</form>
 			</center>
   		 </div>
    
    
   		 <div id="issue_list" class="tab-pane fade">
    	</div>
  </div>
  
  
</div>
 
 
 

 










<%@include file="footer.jsp" %>
</body>
</html>