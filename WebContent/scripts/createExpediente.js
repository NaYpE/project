var xhr = new XMLHttpRequest();
$(
    function()
    {
        $("#sendMessageButton").click
        (
            function()
            {
               var expedientes = {
                    expediente :$("#txtExpediente").val(),
                    tomo : $("#txtTomo").val(),
                    partidojuicio :$("#txtPArtidoJuicio").val(),
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
                }
               var stringExpediente = JSON.stringify(expedientes);
                var jsonExp =  new FormData();
                jsonExp.append("jsonExpediente",stringExpediente);        
                
                xhr.open("post","CreateExpedienteServlet",true);
                xhr.onreadystatechange = callback;
                
                xhr.send(jsonExp);
            } 
        )
        
            
    }
)

function callback()
{
	if(xhr.readyState == 4 && xhr.status==200)
		{
            console.log("se completo la consulta");
		}
	}

