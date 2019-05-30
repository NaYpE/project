
$(
    function()
    {
        $("#sendMessageButton").click
        (
            function()
            {
                var usuarios = {
                    nombres :$("#txtExpediente").val(),
                    apellidoPaterno : $("#txtTomo").val(),
                    apellidoMaterno :$("#txtPArtidoJuicio").val(),
                    fechaNacimiento : $("#txtbrowser").val(),
                    sexo : $("#txtActor").val(),
                    correo : $("#txtAbogadoPat").val(),
                    password : $("#txtAutorizados").val(),
                    confirmaPassword : $("#txtDemandado").val()
                   
                }
            alert(JSON.stringify(expedientes));
            } 
        )
        
            
    }
)
