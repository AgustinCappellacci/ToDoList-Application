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
        const items = await request.json();
        let itemHtml = "";
        for(let item of items){
            itemHtml += '<tr><td>' + item.id + '</td><td>' + item.carpeta + '</td><td>' + item.estaCompletada + '</td><td>' + item.tarea + '</td></tr>';
        }



        document.getElementById("listaDeItems").innerHTML = itemHtml;

}