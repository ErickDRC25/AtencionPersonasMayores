$(document).ready(function () { 
    $('#tblRol').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/back/rol/paginado",
            "type": "GET",
            "data": function (d) {
                d.page = d.start / d.length;
                d.size = d.length;
                d.search = d.search.value;
            },
            "dataSrc": function (json) {
                json.recordsTotal = json.totalElements;
                json.recordsFiltered = json.totalElements;
                return json.content;
            }
        },
        "columns": [
            {
                "data": "id_rol"
            },
            {
                "data": "nombre"
            },
            {
                "data": "estado",
                "render": function (data) {
                    return data == 1 
                        ? '<span class="text-active">Activo</span>' 
                        : '<span class="text-inactive">Inactivo</span>';
                }
            },
            {
                "data": "id_rol",
                "render": function (data) {
                    return '' +
                        '<a href="/rol/editar?id=' + data + '" class="btn btn-success btn-sm">Editar</a>';
                }
            }
        ],
        "lengthMenu": [5, 20, 35, 50],
        "pageLength": 5
    });
});
