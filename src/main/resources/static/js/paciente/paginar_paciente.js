alert("hola");
$(document).ready(function () {
  $("#tblPacientes").DataTable({
    processing: true,
    serverSide: true,
    ajax: {
      url: "/back/paciente/paginado",
      type: "GET",
      data: function (d) {
        d.page = d.start / d.length;
        d.size = d.length;
        d.search = d.search.value;
      },
      dataSrc: function (json) {
        json.recordsTotal = json.totalElements;
        json.recordsFiltered = json.totalElements;
        return json.content;
      },
    },
    columns: [
      { data: "id", className: "text-center" },
      { data: "nombreCompleto", className: "text-center" },
      { data: "dni", className: "text-center" },
      { data: "telefono", className: "text-center" },
      {
        data: "estado",
        className: "text-center",
        render: function (data, type, row) {
          if (data === 1) {
            return '<span class="badge bg-success">Activo</span>';
          } else {
            return '<span class="badge bg-danger">Inactivo</span>';
          }
        },
      },

      {
        data: null,
        className: "text-center",
        render: function (data, _, _) {
          return `
        <div class="d-flex justify-content-center gap-2">
            <button class="btn btn-wargnig  ver-mas" data-id="${data.id}"><i class="fas fa-eye"></i> Info</button>
            <button class="btn btn btn-warning actualizar" data-id="${data.id}"><i class="fas fa-edit"></i></button>
        </div>
    `;
        },
      },
    ],

    lengthMenu: [5, 10, 20],
    pageLength: 5,
  });

  $("#tblPacientes").on("click", ".ver-mas", function () {
    let idPaciente = $(this).data("id"); 
    window.location.href = "/paciente/obtener?id=" + idPaciente;
  });

  $("#tblPacientes").on("click", ".actualizar", function () {
    let idPaciente = $(this).data("id"); 

    window.location.href = "/paciente/editar?id=" + idPaciente;
  });
});
