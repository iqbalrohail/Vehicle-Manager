$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleStatus , status){
			$('#idEdit').val(vehicleStatus .id);
			$('#detailsEdit').val(vehicleStatus .details);
			$('#descriptionEdit').val(vehicleStatus .description);
		});
		$('#editModal').modal();
	});


});