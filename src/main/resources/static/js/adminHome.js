
function deleteStudent(link) {
//	var xhttp = new XMLHttpRequest();
//	xhttp.open("DELETE", link.href, true);
//	xhttp.send();
//	link.removeAttribute('href');
//	link.href='#';	

    
    
    alert(link.href);
    $.ajax({
        url: link.href,
        type: 'DELETE',
        success: function(result) {
           console.log(result);
        }
    });
    link.href='#';
    location.reload();
}