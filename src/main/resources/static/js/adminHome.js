
function deleteStudent(link) {
	var xhttp = new XMLHttpRequest();
	xhttp.open("DELETE", link.href, true);
	xhttp.send();
	link.removeAttribute('href');
	link.href='#';	
    location.reload();
}