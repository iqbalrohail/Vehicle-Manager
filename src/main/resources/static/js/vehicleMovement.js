$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleMovement, status){
			$('#idEdit').val(vehicleMovement.id);


			$('#date1Edit').val(vehicleMovement.date1);


            			$('#ddllocation1Edit').val(vehicleMovement.locationid1);

            			$('#date2Edit').val(vehicleMovement.date2);

			$('#ddllocation2Edit').val(vehicleMovement.locationid2);
			$('#remarksEdit').val(vehicleMovement.remarks);
		});
		$('#editModal').modal();
	});

});