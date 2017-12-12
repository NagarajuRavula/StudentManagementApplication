function enableFileds()
{
  document.getElementById("formFields").disabled = false;
 
}
function checkName(nameObj) {
    var name = nameObj.value;
    var regEx = /^[A-Za-z\s]+$/;
	if (name==null||name == "") {
		alert("Name must be enterd");
		setTimeout(function() {
			nameObj.focus()
		}, 10);

		return false;
	}
	 if (!name.match(regEx)) {
		alert("Name must contain letters and spaces only");
		setTimeout(function() {
			nameObj.focus()
		}, 10);
		return false;
	}
}
function checkGender() {

	gender = document.getElementById("gender").value;
	if (gender == "Gender") {
		alert("Please select gender");
		setTimeout(function() {
			document.getElementById("gender").focus()
		}, 10);
		return false;

	} else {
		return true;
	}

}

function checkPassword(passwordObj)
{
	var password=passwordObj.value;
	passwordLength=password.length;
	var message;
    var regEx = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{5,15})");
	if(password==""||password==null)
		{
		   message="Password must be entered";
		   document.getElementById("errorMessageforpassword").innerHTML=message;
		   setTimeout(function() {
			   passwordObj.focus()
			}, 10);
			return false;
		  
		}

	else if(!password.match(regEx))
		{
		  message="password must be 5-15 character length And, must include At-least one low,high alphabet and number";
		  document.getElementById("errorMessageforpassword").innerHTML=message;
		   setTimeout(function() {
			   passwordObj.focus()
			}, 10);
			return false;
		}
	else
	{
		document.getElementById("errorMessageforpassword").innerHTML="";
	}
	
}


function temp()
{
	
	
	var element = document.getElementById('gender');
    element.value = valueToSelect;
}

function checkNumber(numberObj)
{
	var number=numberObj.value;
	console.log(number);
	console.log(number.length);
	var upper=numberObj.max;
	var valid=number.valid;
	console.log("valid:"+valid);
	var regEx = new RegExp("^[0-9]+$");
	var message;
	if(number==null||number=="")
		{
		message="Filed must contain value";
		console.log("inside empty");
		document.getElementById("errorMessagefor"+numberObj.name).innerHTML=message;
		setTimeout(function() {
			numberObj.focus()
		}, 10);
		return false;
		
		}
		
	 if (!number.match(regEx)) {
		message="Filed must contain only numbers";
		//document.getElementById("errorMessageforpresentclass").innerHTML=message;
		console.log("inside not match");
		document.getElementById("errorMessagefor"+numberObj.name).innerHTML=message;
		
		setTimeout(function() {
			numberObj.focus()
		}, 10);
		return false;
	}
	 else{
		 document.getElementById("errorMessagefor"+numberObj.name).innerHTML="";
	 }

	
	
}

