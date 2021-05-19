$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleType, status){
			$('#idEdit').val(vehicleType.id);
			$('#detailsEdit').val(vehicleType.details);
			$('#descriptionEdit').val(vehicleType.description);
		});
		$('#editModal').modal();
	});


});