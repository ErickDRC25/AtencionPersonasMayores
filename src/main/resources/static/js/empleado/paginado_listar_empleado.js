$(document).ready(function () {
    $('#tblEmpleado').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/back/empleado/paginado",
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
            { "data": "idEmpleado", "className": "text-center" },
            { "data": "nombreEmpleado", "className": "text-center" },
            { "data": "telefono", "className": "text-center" },
            { "data": "email", "className": "text-center" },
            { "data": "rol", "className": "text-center" },
            { "data": "estado", "className": "text-center" },

            {
                "data": null,
                "className": "text-center",
                "render": function (data, _, _) {
                    return `
                <div class="d-flex justify-content-center gap-2">
                    <button class="btn btn-sm btn-primary">Ver mas</button>
                    <button class="btn btn-sm btn-warning">Actualizar</button>
                </div>
            `;
                }
            }
        ],

        "lengthMenu": [5, 10, 15, 20],
        "pageLength": 10
    })
})