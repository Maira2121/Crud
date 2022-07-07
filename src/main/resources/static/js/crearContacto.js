// Call the dataTables jQuery plugin
$(document).ready(function () {
    //on ready
});

async function crearContacto() {
    let datos = {}
    datos.nombreCompleto = document.getElementById('nombre').value;
    datos.phoneNumber = document.getElementById('telefono').value;
    datos.email = document.getElementById('email').value;
    datos.fechaNacimiento = Date.parse(document.getElementById('fechaNacimiento').value);
    const request = await fetch('api/contacto', {
        method: 'POST',
        headers: {
            "Accepts": "application/json",
            "Content-Type": "application/json"
        },body: JSON.stringify(datos)
    });
    alert("Contacto creado con éxito")
    window.location.href = 'index.html'
}


