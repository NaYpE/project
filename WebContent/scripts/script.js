
function validation(){
	var email = document.getElementById("txtCorreo").value;
	var password = document.getElementById("txtPassword").value;
	
	var emailReg = "^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$";
	if( email ==='' || password ===''){
		return false;
	}else if(!(email).match(emailReg)){
		alert("Correo no valido...!!!!!!");
		return false;
	}else{
		return true;
	}
}

function login() {
	
	var email = document.getElementById("txtCorreo").value;
	var password = document.getElementById("txtPassword").value;
	
	if (validation()) // Calling validation function
	{
		callServlet()
		
	}else{
		alert("Intente de nuevo");
	}
}

function crearCuenta() {
	  document.getElementById("frmDatos").submit();
}

$('.carousel').carousel({
  interval: 4000
})

function callServlet() {
   document.forms[0].action = "LogInServlet";
   document.forms[0].submit();
   document.getElementById("frmLogIn").submit();
}
