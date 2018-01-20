// JavaScript Document
$(document).ready(function() {
	 $('[data-toggle="tooltip"]').tooltip();   
  $(".js-select-basic-single").select2({placeholder: "Seleccione"});
});
$('.fecha').datepicker({
    dateFormat: "dd/mm/yy"
});