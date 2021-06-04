$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleHire, status){
			$('#idEdit').val(vehicleHire.id);

						var dateOut = vehicleHire.dateOut.substr(0,10);
			$('#dateOutEdit').val(vehicleHire.dateOut);

						$('#timeOutEdit').val(vehicleHire.timeOut);

									var dateIn = vehicleHire.dateIn.substr(0,10);
									$('#dateInEdit').val(vehicleHire.dateIn);

												$('#timeInEdit').val(vehicleHire.timeIn);
			$('#ddlClientDetailsEdit').val(vehicleHire.clientid);
						$('#ddlLocationDetailsEdit').val(vehicleHire.locationid);
			$('#priceEdit').val(vehicleHire.price);
		});
		$('#editModal').modal();
	});

});


