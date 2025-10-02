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
            { "data": "fecha", "className": "text-center" },
            { "data": "estado", "className": "text-center" },

            {
                "data": null,
                "className": "text-center",
                "render": function (data, _, _) {
                    return `
                <div class="d-flex justify-content-center gap-2">
                    <button class="btn btn-sm btn-primary ver-mas" data-id="${data.id_cita}">Ver más</button>
                    <button class="btn btn-sm btn-warning actualizar" data-id="${data.id_cita}">Actualizar</button>

                </div>
            `;
                }
            }
        ],

        "lengthMenu": [5, 10, 15, 20],
        "pageLength": 10
    })

    $('#tblCita').on('click', '.ver-mas', function () {
        let idCita = $(this).data("id");
        window.location.href = "/citas/ver?id=" + idCita;
    });


    $('#tblCita').on('click', '.actualizar', function () {
        let idCita = $(this).data("id");


        window.location.href = "/citas/actualizar?id=" + idCita;

    });

})