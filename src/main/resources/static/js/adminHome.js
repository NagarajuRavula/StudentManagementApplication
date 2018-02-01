window.onload = function() {
	buildtable();
}

function deleteStudent() {
	$.ajax({
		url : this.name,
		type : 'DELETE',
		success : function(result, status) {
			// alert("record deleted successfully");
			toastr.success('record deleted successfully!', 'Success', {timeOut: 2000})
			$("tr#row:not(:first)").remove();
			buildtable();
		},
		error : function(result, status) {
			//alert("Error occured : " + status);
			toastr.error('Error occured!', 'Error', {timeOut: 2000})
		}
	});
}

function buildtable() {
	$.ajax({
		url : contextPath + '/student',
		type : 'GET',
		success : function(result, status) {
			var studentTable = document.getElementById("table1");
			var tbody = document.createElement("tbody");

			for (var i = 0; i < result.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row");
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
				a2.id='delete_anchor';
				a2.className="success btn btn-success"
				a2.name = 'delete/' + result[i].id;
				a2.onclick = deleteStudent;
				a2.href = '#';
				td7.appendChild(a2);
				tr.appendChild(td7);
				tbody.appendChild(tr);

				studentTable.appendChild(tbody);

			}
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});
}




function toast() {

	console.log("toast-------->")
	toastr.success('We do have the Kapua suite available.', 'Success Alert', {timeOut: 5000})

}
