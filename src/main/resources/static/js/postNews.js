function postList() {
	alert("hello");
	
	
	$.ajax({
		//console.log("before deleting---------->");
		url : 'http://localhost:8081/student/delete?id=266',
		type : 'DELETE',
		success : function(result, status) {
			console.log("after  deleting---------->");
			console.log("status: "+status);
			console.log("res: "+result);
		//	toastr.success(result, 'Success', {timeOut: 2000})
			//$("tr#"+row_id).remove();	 //this one simply mask the row of table		
		//	buildtable();	
		},
		error : function(result, status) {
			//toastr.error(result, 'Error', {timeOut: 2000})
			console.log("error occured deleting");
			console.log("status: "+status);
			console.log("res: "+result);
		}
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	var table =document.getElementById("resolved_issues_table_wrapper");
//	if(table!=null) {
//		console.log("there....")
//		table.remove();
//	}
//	console.log("table is not there");
//	$.ajax({
//		url : contextPath + '/issue',
//		type : 'GET',
//		success : function(result, status) {
//			//var ignoredIssuesTable = document.getElementById("table1");
//			
//			var filteredResult=result.filter(getResolvedIssues);
//			
//			var resolvedIssuesTable=document.createElement("table");
//			resolvedIssuesTable.setAttribute("id", "resolved_issues_table");
//			resolvedIssuesTable.className='table table-striped table-bordered';
//			
//			//document.body.appendChild(ignoredIssuesTable);
//			
//			var thead = document.createElement("thead");
//			var tr = document.createElement("tr");
//			
//			var td1 = document.createElement("th");
//			var txt = document.createTextNode("Id");
//			td1.appendChild(txt);
//			tr.appendChild(td1);
//			
//			var td2 = document.createElement("th");
//			var txt = document.createTextNode("Student Name");
//			td2.appendChild(txt);
//			tr.appendChild(td2);
//            
//			var td3 = document.createElement("th");
//			var txt = document.createTextNode("Issue");
//			td3.appendChild(txt);
//			//td3.style.width='50%';
//			td3.setAttribute("id", "issue");
//			tr.appendChild(td3);
//			
//			
//			var td4 = document.createElement("th");
//			var txt = document.createTextNode("Resolved Date");
//			td4.appendChild(txt);
//			tr.appendChild(td4);
//
////			var td2 = document.createElement("th");
////			var txt = document.createTextNode("Action");
////			td2.appendChild(txt);
////			tr.appendChild(td2);
////			
////			var td2 = document.createElement("th");
////			var txt = document.createTextNode("Action");
////			td2.appendChild(txt);
////			tr.appendChild(td2);
//			
//			thead.appendChild(tr);
//			resolvedIssuesTable.appendChild(thead);
//
//
//
//
//			
//			
//			
//			
//			
//			
//			var tbody = document.createElement("tbody");
//
//			for (var i = 0; i < filteredResult.length; i++) {
//				var tr = document.createElement("tr");
//				tr.setAttribute("id", "row"+filteredResult[i].id);
//			//	alert("row"+result[i].id);
//				var td1 = document.createElement("td");
//				var txt = document.createTextNode(filteredResult[i].id);
//				td1.appendChild(txt);
//				tr.appendChild(td1);
//
//				var td2 = document.createElement("td");
//				var txt = document.createTextNode(filteredResult[i].student.name);
//				td2.appendChild(txt);
//				tr.appendChild(td2);
//
//				var td3 = document.createElement("td");
//				var txt = document.createTextNode(filteredResult[i].issue);
//				td3.appendChild(txt);
//				tr.appendChild(td3);
//				
//				var td3 = document.createElement("td");
//				var date =new Date(filteredResult[i].resolvedDate);
//				var txt = document.createTextNode(date.toDateString());
//				td3.appendChild(txt);
//				tr.appendChild(td3);
//
//
////				var td6 = document.createElement("td");
////				var a1 = document.createElement('a');
////				var linkText1 = document.createTextNode("Resolve");
////				a1.appendChild(linkText1);
////				a1.id='edit_anchor';
////				a1.className='success btn btn-success';
////				a1.href = 'editStudentDetails?email=' + result[i].email;
////				td6.appendChild(a1);
////				tr.appendChild(td6);			
////				
////
////				var td7 = document.createElement("td");
////				var a2 = document.createElement('a');
////				var linkText2 = document.createTextNode("Reject");
////				a2.appendChild(linkText2);
////				a2.href = 'delete/' + result[i].id;
////				a2.setAttribute("id", "row"+result[i].id);
////				a2.className="success btn btn-success"
////				a2.name = 'delete/' + result[i].id;
////			//	a2.onclick = deleteStudent;
////				a2.href = '#';
////				td7.appendChild(a2);
////				tr.appendChild(td7);
//				tbody.appendChild(tr);
//
//			//	ignoredIssuesTable.appendChild(tbody);
//			}
//			resolvedIssuesTable.appendChild(tbody);
//			console.log(resolvedIssuesTable);
//			var resolvedDivElement = document.getElementById("resolved_issues");
//			//$('#table1').DataTable();
//			resolvedDivElement.appendChild(resolvedIssuesTable);
//			$('#resolved_issues_table').DataTable();
//		},
//		error : function(result, status) {
//			alert("Error occured : " + status);
//		}
//	});
//	
	
}































function savePost() {
	alert("savePost:");
	var data= $("#post_form").serialize();
	alert(data);
	$.ajax({
		//console.log("before deleting---------->");
		url : contextPath+'/savePost',
		type : 'POST',
		data : data,
		success : function(result, status) {
			alert("after  saving---------->");
			alert("status: "+status);
			alert("res: "+result);
			toastr.success(result, 'Success', {timeOut: 2000})
		},
		error : function(result, status) {
			toastr.error(result, 'Error', {timeOut: 2000})
			alert("error occured deleting");
			alert("status: "+status);
			alert("res: "+result);
			toastr.success(result, 'Error', {timeOut: 2000})
		}
	});
}



