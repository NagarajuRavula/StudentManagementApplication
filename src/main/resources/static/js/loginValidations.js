var errors = new Array();
window.onload = function() {
	errors = [];
}
function validateLoginForm() {
	if (errors.length > 0)
		return false;
	else
		return true;
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
		index = errors.indexOf(passwordErrorMessage);
		if (index > -1) {
			errors.splice(index, 1);
		}
	}

}