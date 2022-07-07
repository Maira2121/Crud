// Call the dataTables jQuery plugin
$(document).ready(function () {
    //on ready
});

async function actualizarContacto(id) {
    await fetch('api/contacto/' + id, {
        method: 'PUT',
        headers: {
            "Accepts": "application/json",
            "Content-Type": "application/json"
        },
    }).then(function (response) {
        if (response.ok) {
            alert("Contacto actualizado")
            window.location.reload()
        } else {
            alert("Error al modificar el contacto")
        }
    })
}