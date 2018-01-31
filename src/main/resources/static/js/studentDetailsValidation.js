var errors = new Array();
window.onload = function() {
	errors=[];
}
function enableFileds() {
	document.getElementById("formFields").disabled = false;
}
function checkName(nameObj) {
	var nameErrorMessage = "Name must contain letters and spaces only";
	var name = nameObj.value;
	var index;
	var regEx = /^[A-Za-z\s]+$/;
	if (!name.match(regEx)) {
		document.getElementById("errorMessagefor" + nameObj.name).innerHTML = nameErrorMessage;
		nameObj.focus();
		index = errors.indexOf(nameErrorMessage);
		if (index == -1) {
			errors.push(nameErrorMessage);
		}
	} else {
		document.getElementById("errorMessagefor" + nameObj.name).innerHTML = "";
		index = errors.indexOf(nameErrorMessage);
		if (index > -1) {
			errors.splice(index, 1);
		}
	}
}
function checkGenderAndValidatePersonalForm() {

	var genderErrorMessage = "Please select gender";
	gender = document.getElementById("gender").value;
	if (gender == "Gender") {
		document.getElementById("errorMessageforgender").innerHTML = genderErrorMessage;
		document.getElementById("gender").focus();
		return false;

	}

	else {
		//return true;
		document.getElementById("errorMessageforgender").innerHTML = "";
		console.log(errors.length);
		console.log(errors);
		if (errors.length > 0)
			return false;
		else
			return true;
	}

}

function checkPassword(passwordObj) {
	var password = passwordObj.value;
	var passwordLength = password.length;
	var index;
	var passwordErrorMessage = "password must be 5-15 character length And, must include At-least one low,high alphabet and number";
	var regEx = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{5,15})");

	if (!password.match(regEx)) {
		document.getElementById("errorMessageforpassword").innerHTML = passwordErrorMessage;
		passwordObj.focus()
		index = errors.indexOf(passwordErrorMessage);
		if (index == -1) {
			errors.push(passwordErrorMessage);
		}
	} else {
		document.getElementById("errorMessageforpassword").innerHTML = "";
		// return true;
		index = errors.indexOf(passwordErrorMessage);
		if (index > -1) {
			errors.splice(index, 1);
		}
	}

}

function setGender(valueToSelect) {
	var element = document.getElementById('gender');
	if(valueToSelect=="") 
		element.value = "Gender";
	else
	    element.value = valueToSelect;
}

function validateEducationForm() {
	console.log(errors.length);
	console.log(errors);
	if (errors.length > 0)
		return false;
	else
		return true;
}



function validateEditDetailsForm() {
	var genderErrorMessage = "Please select gender";
	gender = document.getElementById("gender").value;
	if (gender == "Gender") {
		document.getElementById("errorMessageforgender").innerHTML = genderErrorMessage;
		document.getElementById("gender").focus();
		return false;

	}

	else {
		document.getElementById("errorMessageforgender").innerHTML = "";
		console.log(errors.length);
		console.log(errors);
		if (errors.length > 0)
			return false;
		else
			return true;
	}

}
