$(document).ready(function () {
    $('#tblCita').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/back/cita/paginado",
            "type": "GET",
            "data": function (d) {
                d.page = d.start / d.length;
                d.size = d.length;
                d.search = d.search.value

            },
            "dataSrc": function (json) {
                json.recordsTotal = json.totalElements;
                json.recordsFiltered = json.totalElements;
                return json.content;
            }
        },
        "columns": [
            { "data": "id_cita", "className": "text-center" },
            { "data": "nombrePaciente", "className": "text-center" },
            { "data": "nombreEmpleado", "className": "text-center" },
            { "data": "motivo", "className": "text-center" },
            {
                "data": "fecha",
                "className": "text-center",
                "render": function (data) {
                    return new Date(data).toLocaleString('es-ES');
                }
            },
            {
                "data": "estado",
                "className": "text-center",
                "render": function (data) {
                    if (data === 1) {
                        return '<span class="text-active">Activo</span>';
                    } else {
                        return '<span class="text-inactive">Inactivo</span>';
                    }
                },
            },
            {
                "data": "id_cita",
                "render": function (data) {
                    return '' +
                        '<div class="d-flex justify-content-center gap-2">' +
                        '<a href="/citas/ver?id=' + data + '" class="btn btn btn-wargnig btn-sm me-1"><i class="fas fa-eye"></i> Ver</a> <a></a>' +
                        '<a href="/citas/actualizar?id=' + data + '" class="btn btn-warning btn-sm"><i class="fas fa-edit"></i></a>' +
                        '</div>'
                }
            }
        ],
        "lengthMenu": [5, 20, 35, 50],
        "pageLength": 5
    });
});