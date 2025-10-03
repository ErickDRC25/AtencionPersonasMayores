$(document).ready(function () {
  $('#tblPacientes').DataTable({
    "processing": true,
    "serverSide": true,
    "ajax": {
      "url": "/back/paciente/paginado",
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
      },
    },
    "columns": [
      { "data": "id", "className": "text-center" },
      { "data": "nombreCompleto", "className": "text-center" },
      { "data": "dni", "className": "text-center" },
      { "data": "telefono", "className": "text-center" },
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
        "data": "id",
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
