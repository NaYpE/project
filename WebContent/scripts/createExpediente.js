var xhr = new XMLHttpRequest();
window.onload = function()
{
	
    document.getElementById("sendMessageButton").addEventListener("click", funNombre);
}     
    function funNombre(){
        expedientes = {  expediente  : $("#txtExpediente").val(),
        tomo : $("#txtTomo").val(),
        partidojuicio : $("#txtPArtidoJuicio").val(),
        juzgado : $("#txtbrowser").val(),
        actor : $("#txtActor").val(),
        abogadoPatrono : $("#txtAbogadoPat").val(),
        autorizados : $("#txtAutorizados").val(),
        demandado : $("#txtDemandado").val(),
        abogadoPatrono2 : $("#txtAbogadoPat2").val(),
        autorizados2 : $("#txtAutorizados").val(),
        juez : $("#txtJuez").val(),
        srio : $("#txtSrio").val(),
        fecha : $("#txtBirth").val()
    };
        var stringExpediente = JSON.stringify(expedientes);
        var formExp =  new FormData();
        formExp.append("txtExpediente",stringExpediente);   
        console.log(stringExpediente);   
        
        xhr.onreadystatechange = callback;
        xhr.open("POST","CreateExpedienteServlet",true);
        xhr.send(formExp);
        }

function callback()
{
	if(xhr.readyState == 4 && xhr.status==200)
		{
            console.log("se completo la consulta");
		}
	}

