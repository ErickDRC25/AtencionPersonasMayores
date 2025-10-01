alert("Bienvenidos");
$(document).ready(function () {
  listado_paciente();
});

function listado_paciente() {
  $.ajax({
    url: "/back/paciente/listarDto",
    success: function (result) {
      console.log(result);
      var contenido = "";
      for (var i = 0; i < result.length; i++) {
        contenido +=
          "<tr>" +
          "<td>" +
          result[i]["id"] +
          "</td>" +
          "<td>" +
          result[i]["nombreCompleto"] +
          "</td>" +
          "<td>" +
          result[i]["dni"] +
          "</td>" +
          "<td>" +
          result[i]["telefono"] +
          "</td>";
        //"<td>" ;
        /* result[i]["alergias"] +
          "</td>" +
          "<td>" +
          result[i]["enfermedades_cronicas"] +
          "</td>";*/
        if (result[i]["estado"] == 1) {
          contenido += '<td><span class="text-active">Activo</span></td>';
        } else {
          contenido += '<td><span class="text-inactive">Inactivo</span></td>';
        }
        contenido +=
          "<td>" +
          '<a href="/paciente/obtener?id=' +
          result[i]["id"] +
          '"  class="btn btn-wargnig" >VER INFO</a>  ' +
          '<a href="/paciente/editar?id=' +
          result[i]["id"] +
          '"  class="btn btn-success " > ACTUALIZAR</a>  ' +
          "</td>" +
          "</tr>";
      }
      $("#tblPacientes").html(contenido);
    },
  });
}
