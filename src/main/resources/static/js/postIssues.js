function issueList() {
	
	var table =document.getElementById("issues_table_wrapper");
	if(table!=null) {
		console.log("there....")
		table.remove();
	}
	console.log("table is not there");
	$.ajax({
		url : contextPath + '/issue',
		type : 'GET',
		success : function(result, status) {
			
			
			var issuesTable=document.createElement("table");
			issuesTable.setAttribute("id", "issues_table");
			issuesTable.className='table table-striped table-bordered';
			
			
			var thead = document.createElement("thead");
			var tr = document.createElement("tr");
			
			var td1 = document.createElement("th");
			var txt = document.createTextNode("Issue Id");
			td1.appendChild(txt);
			tr.appendChild(td1);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Issue Type");
			td2.appendChild(txt);
			tr.appendChild(td2);
            
			var td3 = document.createElement("th");
			var txt = document.createTextNode("Issue");
			td3.setAttribute("id", "issue_message");
			td3.appendChild(txt);
			tr.appendChild(td3);
			
			
			var td4 = document.createElement("th");
			var txt = document.createTextNode("Status");
			td4.appendChild(txt);
			tr.appendChild(td4);
			
			
			var td5 = document.createElement("th");
			var txt = document.createTextNode("Reported Date");
			td5.appendChild(txt);
			tr.appendChild(td5);

			thead.appendChild(tr);
			issuesTable.appendChild(thead);
			

			var filteredResult=result.filter(getLoggedInUserIssues);
			
			
			var tbody = document.createElement("tbody");

			for (var i = 0; i < filteredResult.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row"+filteredResult[i].id);
				var td1 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].id);
				td1.appendChild(txt);
				tr.appendChild(td1);

				var td2 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].issueType);
				td2.appendChild(txt);
				tr.appendChild(td2);

				var td3 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].issue);
				td3.appendChild(txt);
				tr.appendChild(td3);
				
				var td4 = document.createElement("td");
				var txt = document.createTextNode(filteredResult[i].status);
				td4.appendChild(txt);
				tr.appendChild(td4);
				
				
				
				var td5 = document.createElement("td");
				var date =new Date(filteredResult[i].reportedDate);
				var txt = document.createTextNode(date.toDateString());
				td5.appendChild(txt);
				tr.appendChild(td5);

				tbody.appendChild(tr);

			}
			issuesTable.appendChild(tbody);
			console.log(issuesTable);
			var issuesDivElement = document.getElementById("issue_list");
			issuesDivElement.appendChild(issuesTable);
			$('#issues_table').DataTable();
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});	
}


function saveIssue() {
	//alert("post issues");
	var data= $("#issue_form").serialize();
	
	$.ajax({
		url : contextPath+'/saveIssue',
		type : 'POST',
		data : data,
		success : function(result, status) {
			toastr.success(result, 'Success', {timeOut: 2000});
		},
		error : function(result, status) {
			toastr.success(result, 'Error', {timeOut: 2000});
		}
	});
	document.getElementById("text_area").value="";
	var ele = document.getElementsByName("issueType");
	   for(var i=0;i<ele.length;i++)
	      ele[i].checked = false;

	return false;
}




function getLoggedInUserIssues(issue) {
	var loggedInUserId = document.getElementById("id").value;
	//alert(loggedInUserId);
	console.log(issue.student.id);
	//console.log(issue.admin);
	return issue.student.id== loggedInUserId;
}














