$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleModel , status){
			$('#idEdit').val(vehicleModel .id);
			$('#detailsEdit').val(vehicleModel .details);
			$('#descriptionEdit').val(vehicleModel .description);
		});
		$('#editModal').modal();
	});


});