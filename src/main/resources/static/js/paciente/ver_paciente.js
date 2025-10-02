
$(document).ready(function () {
  //#idPaciente viene del html referenciado del controller mmodel
  obtenerCurso($("#idPaciente").html());
});

function obtenerCurso(id) {
  $.ajax({
    url: "/back/paciente/obtener?id=" + id,
    success: function (result) {
      $("#idCargando").hide();
        $("#idPaciente").html(result.id);
        $("#idNombre").html(result.nombre);
        $("#idApellido").html(result.apellido);
        $("#idDni").html(result.dni);
        $("#idFechaNacimiento").html(result.fecha_nacimiento);
        $("#idDireccion").html(result.direccion);
        $("#idTelefono").html(result.telefono);
        $("#idAlergias").html(result.alergias);
        $("#idEnfermedadesCronicas").html(result.enfermedades_cronicas);
        $("#idEstado").html(result.estado);

    },
  });
}
