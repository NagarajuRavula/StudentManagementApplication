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
	href=${pageContext.request.contextPath}/css/postNews.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src=${pageContext.request.contextPath}/js/postNews.js>
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
  
  
<!--   <!--  library for toastr --> -->
<!-- <script type="text/javascript" -->
<!-- 	src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script> -->
<!-- <link -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" -->
<!-- 	rel="stylesheet"> -->
<!-- <script type="text/javascript" -->
<!-- 	src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script> -->
<!-- <link -->
<!-- 	href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" -->
<!-- 	rel="stylesheet"> -->

</head>







<body>
<%@include file="header.jsp" %>
 <h3 id="title">Post News</h3>
 
 <div class="container">
 
 	<ul class="nav nav-pills" id="list">
    	<li class="active"><a data-toggle="pill" href="#new_post" >New Post</a></li>
    	<li><a data-toggle="pill" href="#post_list" onclick="postList()" >Post List</a></li>
    </ul>
  
  	<div class="tab-content">
    	<div id="new_post" class="tab-pane fade in active"> 
     		<center>
 				<form onsubmit="savePost()" id="post_form">
 
				 <p>Please select preferred post type:</p>
 				 <div>
    				<input type="radio" id="postChoice1"
     				name="postType" value="Exam" required>
    				<label for="contactChoice1">Exam</label>

    				<input type="radio" id="postChoice2"
     				name="postType" value="Academic" required>
    				<label for="contactChoice2">Academic</label>
   
  				</div>
  
 					<textarea rows="6" cols="50" placeholder="Type upto 255 characters.." id="text_area" name="textArea" maxlength="255" required></textarea><br>
 					<input type="submit" id="post"  class="btn btn-success" value="Post">
 				</form>
 			</center>
   		 </div>
    
    
   		 <div id="post_list" class="tab-pane fade">
    	</div>
  </div>
  
  
</div>
 
 
 

 










<%@include file="footer.jsp" %>
</body>
</html>