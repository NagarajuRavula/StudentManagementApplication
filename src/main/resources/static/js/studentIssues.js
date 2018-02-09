window.onload = function() {
	pendingIssues();
}

function pendingIssues() {
 
	var table =document.getElementById("pending_issues_table_wrapper");
	if(table!=null) {
		console.log("there....")
		table.remove();
	}
	$.ajax({
		url : contextPath + '/issue',
		type : 'GET',
		success : function(result, status) {
			//var ignoredIssuesTable = document.getElementById("table1");
			
			var filteredResult=result.filter(getPendingIssues);
			
			var pendingIssuesTable=document.createElement("table");
			pendingIssuesTable.setAttribute("id", "pending_issues_table");
			pendingIssuesTable.className='table table-striped table-bordered';
			
			//document.body.appendChild(ignoredIssuesTable);
			
			var thead = document.createElement("thead");
			var tr = document.createElement("tr");
			
			var td1 = document.createElement("th");
			var txt = document.createTextNode("Id");
			td1.appendChild(txt);
			tr.appendChild(td1);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Student Name");
			td2.appendChild(txt);
			tr.appendChild(td2);
            
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Issue");
			td2.appendChild(txt);
			td2.setAttribute("id", "issue");
		//	td2.style.width='50%'; 
			tr.appendChild(td2);
			
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Reported Date");
			td2.appendChild(txt);
			tr.appendChild(td2);
			

			var td2 = document.createElement("th");
			//td2.colSpan = "2";
			var txt = document.createTextNode("Action");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Action");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			thead.appendChild(tr);
			pendingIssuesTable.appendChild(thead);




			
			
			
			
			
			
			var tbody = document.createElement("tbody");

			for (var i = 0; i < filteredResult.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row"+filteredResult[i].id);
			//	alert("row"+result[i].id);
				var td1 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].id);
				td1.appendChild(txt);
				tr.appendChild(td1);

				var td2 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].student.name);
				td2.appendChild(txt);
				tr.appendChild(td2);

				var td3 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].issue);
				td3.appendChild(txt);
				tr.appendChild(td3);
				
				
				var td4 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].reportedDate);
				td4.appendChild(txt);
				tr.appendChild(td4);



				var td6 = document.createElement("td");
				var a1 = document.createElement('a');
				var linkText1 = document.createTextNode("Resolve");
				a1.appendChild(linkText1);
				a1.id='pending';
				a1.className='success btn btn-success';
				a1.name = 'issueToResolve/' + filteredResult[i].id;
			//	a1.href = 'editStudentDetails?email=' + result[i].email;
				a1.onclick = toResolveIssue;
				a1.href = '#';
				td6.appendChild(a1);
				tr.appendChild(td6);			
				

				var td7 = document.createElement("td");
				var a2 = document.createElement('a');
				var linkText2 = document.createTextNode("Ignore");
				a2.appendChild(linkText2);
			//	a2.href = 'delete/' + result[i].id;
				a2.setAttribute("id", "pending");
				a2.className="success btn btn-success"
				a2.name = 'issueToIgnore/' + filteredResult[i].id;
				a2.onclick = toIgnoreIssue;
				a2.href = '#';
				td7.appendChild(a2);
				tr.appendChild(td7);
				tbody.appendChild(tr);

			//	ignoredIssuesTable.appendChild(tbody);
			}
			pendingIssuesTable.appendChild(tbody);
			console.log(pendingIssuesTable);
			var pendingDivElement = document.getElementById("pending_issues");
			//$('#table1').DataTable();
			pendingDivElement.appendChild(pendingIssuesTable);
			$('#pending_issues_table').DataTable();
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});
}

function resolvedIssues() {
	var table =document.getElementById("resolved_issues_table_wrapper");
	if(table!=null) {
		console.log("there....")
		table.remove();
	}
	console.log("table is not there");
	$.ajax({
		url : contextPath + '/issue',
		type : 'GET',
		success : function(result, status) {
			//var ignoredIssuesTable = document.getElementById("table1");
			
			var filteredResult=result.filter(getResolvedIssues);
			
			var resolvedIssuesTable=document.createElement("table");
			resolvedIssuesTable.setAttribute("id", "resolved_issues_table");
			resolvedIssuesTable.className='table table-striped table-bordered';
			
			//document.body.appendChild(ignoredIssuesTable);
			
			var thead = document.createElement("thead");
			var tr = document.createElement("tr");
			
			var td1 = document.createElement("th");
			var txt = document.createTextNode("Id");
			td1.appendChild(txt);
			tr.appendChild(td1);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Student Name");
			td2.appendChild(txt);
			tr.appendChild(td2);
            
			var td3 = document.createElement("th");
			var txt = document.createTextNode("Issue");
			td3.appendChild(txt);
			//td3.style.width='50%';
			td3.setAttribute("id", "issue");
			tr.appendChild(td3);
			
			
			var td4 = document.createElement("th");
			var txt = document.createTextNode("Resolved Date");
			td4.appendChild(txt);
			tr.appendChild(td4);

//			var td2 = document.createElement("th");
//			var txt = document.createTextNode("Action");
//			td2.appendChild(txt);
//			tr.appendChild(td2);
//			
//			var td2 = document.createElement("th");
//			var txt = document.createTextNode("Action");
//			td2.appendChild(txt);
//			tr.appendChild(td2);
			
			thead.appendChild(tr);
			resolvedIssuesTable.appendChild(thead);




			
			
			
			
			
			
			var tbody = document.createElement("tbody");

			for (var i = 0; i < filteredResult.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row"+filteredResult[i].id);
			//	alert("row"+result[i].id);
				var td1 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].id);
				td1.appendChild(txt);
				tr.appendChild(td1);

				var td2 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].student.name);
				td2.appendChild(txt);
				tr.appendChild(td2);

				var td3 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].issue);
				td3.appendChild(txt);
				tr.appendChild(td3);
				
				var td3 = document.createElement("td");
				var date =new Date(filteredResult[i].resolvedDate);
				var txt = document.createTextNode(date.toDateString());
				td3.appendChild(txt);
				tr.appendChild(td3);


//				var td6 = document.createElement("td");
//				var a1 = document.createElement('a');
//				var linkText1 = document.createTextNode("Resolve");
//				a1.appendChild(linkText1);
//				a1.id='edit_anchor';
//				a1.className='success btn btn-success';
//				a1.href = 'editStudentDetails?email=' + result[i].email;
//				td6.appendChild(a1);
//				tr.appendChild(td6);			
//				
//
//				var td7 = document.createElement("td");
//				var a2 = document.createElement('a');
//				var linkText2 = document.createTextNode("Reject");
//				a2.appendChild(linkText2);
//				a2.href = 'delete/' + result[i].id;
//				a2.setAttribute("id", "row"+result[i].id);
//				a2.className="success btn btn-success"
//				a2.name = 'delete/' + result[i].id;
//			//	a2.onclick = deleteStudent;
//				a2.href = '#';
//				td7.appendChild(a2);
//				tr.appendChild(td7);
				tbody.appendChild(tr);

			//	ignoredIssuesTable.appendChild(tbody);
			}
			resolvedIssuesTable.appendChild(tbody);
			console.log(resolvedIssuesTable);
			var resolvedDivElement = document.getElementById("resolved_issues");
			//$('#table1').DataTable();
			resolvedDivElement.appendChild(resolvedIssuesTable);
			$('#resolved_issues_table').DataTable();
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});
}

function ignoredIssues() {
	
 
	var table =document.getElementById("ignored_issues_table_wrapper");
	if(table!=null) {
		console.log("there....")
		table.remove();
	}
	$.ajax({
		url : contextPath + '/issue',
		type : 'GET',
		success : function(result, status) {
			//var ignoredIssuesTable = document.getElementById("table1");
			
			var filteredResult=result.filter(getIgnoredIssues);
			
			var ignoredIssuesTable=document.createElement("table");
			ignoredIssuesTable.setAttribute("id", "ignored_issues_table");
			ignoredIssuesTable.className='table table-striped table-bordered';
			
			//document.body.appendChild(ignoredIssuesTable);
			
			var thead = document.createElement("thead");
			var tr = document.createElement("tr");
			
			var td1 = document.createElement("th");
			var txt = document.createTextNode("Id");
			td1.appendChild(txt);
			tr.appendChild(td1);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Student Name");
			td2.appendChild(txt);
			tr.appendChild(td2);
            
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Issue");
			td2.appendChild(txt);
			//td2.style.width='50%';
			td2.setAttribute("id", "issue");
			tr.appendChild(td2);

			var td2 = document.createElement("th");
			var txt = document.createTextNode("Ignored Date");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Action");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			thead.appendChild(tr);
			ignoredIssuesTable.appendChild(thead);




			
			
			
			
			
			
			var tbody = document.createElement("tbody");

			for (var i = 0; i < filteredResult.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row"+filteredResult[i].id);
			//	alert("row"+result[i].id);
				var td1 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].id);
				td1.appendChild(txt);
				tr.appendChild(td1);

				var td2 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].student.name);
				td2.appendChild(txt);
				tr.appendChild(td2);

				var td3 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].issue);
				td3.appendChild(txt);
				tr.appendChild(td3);
				
				
				var td3 = document.createElement("td");
				var date=new Date(filteredResult[i].ignoredDate);
				var txt = document.createTextNode(date.toDateString());
				td3.appendChild(txt);
				tr.appendChild(td3);


//				var td6 = document.createElement("td");
//				var a1 = document.createElement('a');
//				var linkText1 = document.createTextNode("Resolve");
//				a1.appendChild(linkText1);
//				a1.id='edit_anchor';
//				a1.className='success btn btn-success';
//				a1.href = 'editStudentDetails?email=' + result[i].email;
//				td6.appendChild(a1);
//				tr.appendChild(td6);			
				

				var td7 = document.createElement("td");
				var a2 = document.createElement('a');
				var linkText2 = document.createTextNode("Resolve");
				a2.appendChild(linkText2);
				a2.setAttribute("id", "ignored"	);
				a2.className="success btn btn-success"
				a2.name = 'issueToResolve/' + filteredResult[i].id;
				a2.onclick = toResolveIssue;
				a2.href = '#';
				td7.appendChild(a2);
				tr.appendChild(td7);
				tbody.appendChild(tr);

			//	ignoredIssuesTable.appendChild(tbody);
			}
			ignoredIssuesTable.appendChild(tbody);
			console.log(ignoredIssuesTable);
			var ignoredDivElement = document.getElementById("ignored_issues");
			//$('#table1').DataTable();
			ignoredDivElement.appendChild(ignoredIssuesTable);
			$('#ignored_issues_table').DataTable();
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});
}


function getIgnoredIssues(issue) {

	return issue.status=="ignored";
	
}


function getPendingIssues(issue) {
	return issue.status=="pending";
	
}


function getResolvedIssues(issue) {

	return issue.status=="resolved";
	
}

function toIgnoreIssue() {
	alert(this.name);
	$.ajax({
		url : this.name,
		type : 'PUT',
		success : function(result, status) {
			//toastr.success('record deleted successfully!', 'Success', {timeOut: 2000})
			//$("tr#"+row_id).remove();	 //this one simply mask the row of table		
			//buildtable();	
			var table =document.getElementById("pending_issues_table_wrapper");
		    if(table!=null) {
			  console.log("there....")
			  table.remove();
		    }
		    pendingIssues();
		},
		error : function(result, status) {
			//toastr.error('Error occured!', 'Error', {timeOut: 2000})
			console.log("error occured----")
		}
	});
}

function toResolveIssue() {
	console.log("id is :"+this.id);
	id=this.id
	alert(this.name);
	$.ajax({
		url : this.name,
		type : 'PUT',
		success : function(result, status) {
			console.log("updated-----")
			//toastr.success('record deleted successfully!', 'Success', {timeOut: 2000})
			//$("tr#"+row_id).remove();	 //this one simply mask the row of table		
			//buildtable();	
			
		var table =document.getElementById(this.id+"_issues_table_wrapper");
	     if(table!=null) {
		  console.log("there....")
		  table.remove();
	    }
	    // this.id+Issues();
	     var a = id+'Issues';
	     console.log("a is: "+a);
	     window[a]();

			
		},
		error : function(result, status) {
			//toastr.error('Error occured!', 'Error', {timeOut: 2000})
			console.log("error occured----")
		}
	});
}



