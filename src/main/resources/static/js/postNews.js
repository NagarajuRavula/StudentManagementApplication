function postList() {
	
	var table =document.getElementById("posts_table_wrapper");
	if(table!=null) {
		console.log("there....")
		table.remove();
	}
	console.log("table is not there");
	$.ajax({
		url : contextPath + '/post',
		type : 'GET',
		success : function(result, status) {
			
			
			var postsTable=document.createElement("table");
			postsTable.setAttribute("id", "posts_table");
			postsTable.className='table table-striped table-bordered';
			
			
			var thead = document.createElement("thead");
			var tr = document.createElement("tr");
			
			var td1 = document.createElement("th");
			var txt = document.createTextNode("Post Id");
			td1.appendChild(txt);
			tr.appendChild(td1);
			
			var td2 = document.createElement("th");
			var txt = document.createTextNode("Post Type");
			td2.appendChild(txt);
			tr.appendChild(td2);
            
			var td3 = document.createElement("th");
			var txt = document.createTextNode("Admin Name");
			td3.appendChild(txt);
			tr.appendChild(td3);
			
			
			var td4 = document.createElement("th");
			var txt = document.createTextNode("Post");
			td4.appendChild(txt);
			td4.setAttribute("id", "post_message");
			tr.appendChild(td4);
			
			
			var td5 = document.createElement("th");
			var txt = document.createTextNode("Posted Date");
			td5.appendChild(txt);
			tr.appendChild(td5);

			thead.appendChild(tr);
			postsTable.appendChild(thead);


			
			
			var tbody = document.createElement("tbody");

			for (var i = 0; i < result.length; i++) {
				var tr = document.createElement("tr");
				tr.setAttribute("id", "row"+result[i].id);
				var td1 = document.createElement("td");
				var txt = document.createTextNode(result[i].id);
				td1.appendChild(txt);
				tr.appendChild(td1);

				var td2 = document.createElement("td");
				var txt = document.createTextNode(result[i].postType);
				td2.appendChild(txt);
				tr.appendChild(td2);

				var td3 = document.createElement("td");
				var txt = document.createTextNode(result[i].admin.name);
				td3.appendChild(txt);
				tr.appendChild(td3);
				
				var td4 = document.createElement("td");
				var txt = document.createTextNode(result[i].post);
				td4.appendChild(txt);
				tr.appendChild(td4);
				
				
				
				var td5 = document.createElement("td");
				var date =new Date(result[i].postedDate);
				var txt = document.createTextNode(date.toDateString());
				td5.appendChild(txt);
				tr.appendChild(td5);

				tbody.appendChild(tr);

			}
			postsTable.appendChild(tbody);
			console.log(postsTable);
			var postsDivElement = document.getElementById("post_list");
			postsDivElement.appendChild(postsTable);
			$('#posts_table').DataTable();
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});	
}


function savePost() {
	var data= $("#post_form").serialize();
	alert(data);
	$.ajax({
		url : contextPath+'/savePost',
		type : 'POST',
		data : data,
		success : function(result, status) {
			alert("post saved successfully!")
			toastr.success(result, 'Success', {timeOut: 4000});
		},
		error : function(result, status) {
			alert("Error occured!");
			toastr.success(result, 'Error', {timeOut: 4000});
		}
	});
}



