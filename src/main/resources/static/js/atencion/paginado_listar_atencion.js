$(document).ready(function () {
    $('#tblAtencion').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/back/atencion/paginado",
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
            { "data": "id_atencion", "className": "text-center" },
            { "data": "nombrePaciente", "className": "text-center" },
            { "data": "nombreEmpleado", "className": "text-center" },
            {
                "data": "fecha",
                "className": "text-center",
                "render": function (data) {
                    return new Date(data).toLocaleString('es-ES');
                }
            },
            {
                "data": "diagnostico",
                "className": "text-center",
                "render": function (data) {
                    return data ? (data.length > 50 ? data.substring(0, 50) + '...' : data) : '';
                }
            },
            {
                "data": "tratamiento",
                "className": "text-center",
                "render": function (data) {
                    return data ? (data.length > 50 ? data.substring(0, 50) + '...' : data) : '';
                }
            },
            {
                "data": "id_atencion",
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