// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarContactos();
    $('#contactos').DataTable();
});

async function cargarContactos() {
    const request = await fetch('api/contactos', {
        method: 'GET',
        headers: {
            "Accepts": "application/json",
            "Content-Type": "application/json"
        }
    });
    const contactos = await request.json();

    let listadoHtml = '';

    for (let contacto of contactos) {
        const string = (contacto.fechaNacimiento).toString()
        const fixString = string.slice(0, -19);
        let btnEliminar = '<a onclick="eliminarContacto(' + contacto.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        let btnActualizar = '<a onclick="mostrarModal(' + contacto.id + ')" class="btn btn-warning btn-circle btn-sm" href="#" data-toggle="modal">' +
            '<i class="fas fa-pen"></i></a>'
        let contactoHtml = '<tr><td>' + contacto.id + '</td><td>' + contacto.nombreCompleto + '</td><td>'
            + contacto.phoneNumber + '</td><td>' + contacto.email + '</td><td>'
            + fixString + '</td><td>' + btnEliminar + ' ' + btnActualizar + '</td></tr>'
        listadoHtml += contactoHtml;
    }

    document.querySelector('#contactos tbody').outerHTML = listadoHtml;
}

async function eliminarContacto(id) {
    if (window.confirm("¿Está seguro de eliminar este contacto?")) {
        await fetch('api/contacto/' + id, {
            method: 'DELETE',
            headers: {
                "Accepts": "application/json",
                "Content-Type": "application/json"
            },
        }).then(function (response) {
            if (response.ok) {
                alert("Contacto eliminado")
                window.location.reload()
            } else {
                alert("Error al eliminar el contacto")
            }
        })
    }
}

async function actualizarContacto(id) {
    let datos = {}
    datos.nombreCompleto = document.getElementById('nombre').value;
    datos.phoneNumber = document.getElementById('telefono').value;
    datos.email = document.getElementById('email').value;
    datos.fechaNacimiento = Date.parse(document.getElementById('fechaNacimiento').value);
    await fetch('api/contacto/'+ id, {
        method: 'PUT',
        headers: {
            "Accepts": "application/json",
            "Content-Type": "application/json"
        },body: JSON.stringify(datos)
    }).then(function (response) {
        if (response.ok) {
            alert("Contacto actualizado")
            window.location.reload()
        } else {
            alert("Error al modificar el contacto")
        }
    })
}

async function mostrarModal(id){
    $('#modalActualizar').modal('show')
    const request = await fetch('api/contacto/' + id, {
        method: 'GET',
        headers: {
            "Accepts": "application/json",
            "Content-Type": "application/json"
        }
    });
    const contacto = await request.json();
    console.log(contacto.id)
    const string = (contacto.fechaNacimiento).toString()
    const fixString = string.slice(0, -19);

    document.querySelector('#modalActualizar form').innerHTML = '<div class="form-group">\n' +
        '<div class="form-group"><input type="text" class="form-control form-control-user" id="id_contacto"\n' +
        'value="' + contacto.id + '" readonly></div><div class="form-group">\n' +
        '<input type="text" class="form-control form-control-user" id="nombre" value="' + contacto.nombreCompleto + '"></div>\n' +
        '<div class="form-group"><input type="text" class="form-control form-control-user" id="telefono"\n' +
        'value="' + contacto.phoneNumber + '"></div></div><div class="form-group">\n' +
        '<input type="email" class="form-control form-control-user" id="email" value="' + contacto.email + '"></div>\n' +
        '<div class="form-group row"><div class="col-sm-6 mb-3 mb-sm-0"><input type="date" class="form-control form-control-user"\n' +
        'id="fechaNacimiento" value="'+ fixString+'"></div></div>' +
        '<div class="modal-footer"><a onclick="actualizarContacto(' + contacto.id + ')" class="btn btn-success"><i class="fas fa-save"></i> Guardar\n' +
        '</a><button class="btn btn-secondary" type="button" data-dismiss="modal"> X Cancel</button></div>';
}