window.onload = function() {
	buildtable();
}

function deleteStudent() {
//	row_id=this.id; //storing the id of deleted row in global var row_id
	$.ajax({
		url : this.name,
		type : 'DELETE',
		success : function(result, status) {
			console.log("res"+result);
			toastr.success(result, 'Success', {timeOut: 2000})
			//$("tr#"+row_id).remove();	 //this one simply mask the row of table		
			buildtable();	
		},
		error : function(result, status) {
			toastr.error(result, 'Error', {timeOut: 2000})
		}
	});
}

function buildtable() {
	
	var table =document.getElementById("table1_wrapper");
	if(table!=null) {
		console.log("there....")
		table.remove();
	}
	
	
	$.ajax({
		url : contextPath + '/student',
		type : 'GET',
		success : function(result, status) {
			//var studentTable = document.getElementById("table1");
			
			
			var studentTable=document.createElement("table");
			studentTable.setAttribute("id", "table1");
			studentTable.className='table table-striped table-bordered';
			
			document.body.appendChild(studentTable);
			
			var thead = document.createElement("thead");
			var tr = document.createElement("tr");
			
			var td1 = document.createElement("th");
			var txt = document.createTextNode("Id");
			td1.appendChild(txt);
			tr.appendChild(td1);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Name");
			td2.appendChild(txt);
			tr.appendChild(td2);
            
			var td2 = document.createElement("th");
			var txt = document.createTextNode("FatherName");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Email");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Gender");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Edit");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Delete");
			td2.appendChild(txt);
			tr.appendChild(td2);
			
			thead.appendChild(tr);
			studentTable.appendChild(thead);




			
			
			
			
			
			
			var tbody = document.createElement("tbody");

			for (var i = 0; i < result.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row"+result[i].id);
			//	alert("row"+result[i].id);
				var td1 = document.createElement("td");
				var txt = document.createTextNode(result[i].id);
				td1.appendChild(txt);
				tr.appendChild(td1);

				var td2 = document.createElement("td");
				var txt = document.createTextNode(result[i].name);
				td2.appendChild(txt);
				tr.appendChild(td2);

				var td3 = document.createElement("td");
				var txt = document.createTextNode(result[i].fatherName);
				td3.appendChild(txt);
				tr.appendChild(td3);

				var td4 = document.createElement("td");
				var txt = document.createTextNode(result[i].email);
				td4.appendChild(txt);
				tr.appendChild(td4);

				var td5 = document.createElement("td");
				var txt = document.createTextNode(result[i].gender);
				td5.appendChild(txt);
				tr.appendChild(td5);

				var td6 = document.createElement("td");
				var a1 = document.createElement('a');
				var linkText1 = document.createTextNode("View/Edit");
				a1.appendChild(linkText1);
				a1.id='edit_anchor';
				a1.className='success btn btn-success';
				a1.href = 'editStudentDetails?email=' + result[i].email;
				td6.appendChild(a1);
				tr.appendChild(td6);			
				

				var td7 = document.createElement("td");
				var a2 = document.createElement('a');
				var linkText2 = document.createTextNode("Delete");
				a2.appendChild(linkText2);
				a2.href = 'delete/' + result[i].id;
				a2.setAttribute("id", "row"+result[i].id);
				a2.className="success btn btn-success"
				a2.name = 'delete/' + result[i].id;
				a2.onclick = deleteStudent;
				a2.href = '#';
				td7.appendChild(a2);
				tr.appendChild(td7);
				tbody.appendChild(tr);

				//studentTable.appendChild(tbody);
			}
			studentTable.appendChild(tbody);
			console.log(studentTable);
			$('#table1').DataTable()

		},
		error : function(result, status) {
			//alert("Error occured : " + status);
			toastr.error(status, 'Error', {timeOut: 2000})
		}
	});
}


