$(document).ready(function(){
    cargarItems();
});


async function cargarItems () {

        const request = await fetch('/items', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        });
        let items = await request.json();
        let itemHtml = "";

        for(let item of items){
            let botonEditar = '<button onClick="editar(' +item.id + ')">Editar</button>'
            let botonEliminar = '<button onClick="eliminarItem(' +item.id + ')">Eliminar</button>'
            itemHtml += '<tr><td>' + item.tarea + '</td><td>' + botonEditar + '</td><td>' + botonEliminar + '</td></tr>';
        }



        document.getElementById("listaDeItems").innerHTML = itemHtml;

}

async function eliminarItem (id){
    const request = await fetch('/items/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
}

async function agregarItem() {
    let datos = {};
    datos.tarea = document.getElementById("textoTarea").value;

    const request = await fetch('/items/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
}

function editar(id) {
    document.getElementById("editar").innerHTML = '<div>><p>Ingrese el nuevo texto</p><input type="text" id="textoNuevo"><button onClick="editarItem(' + id + ')">Ok</button></div>'

}

async function editarItem(id){
    let datos = {};
    datos.id = id;
    datos.tarea = document.getElementById("textoNuevo").value;
    const request = await fetch('/items/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })

    document.getElementById("editar").innerHTML = "";
}