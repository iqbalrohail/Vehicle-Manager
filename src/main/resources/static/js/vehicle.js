/**
 *
 */

$('document').ready(function() {
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicle, status){
					$('#txtIdEdit').val(vehicle.id);
					$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
								$('#txtNameEdit').val(vehicle.name);
											$('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);

												var regDate = vehicle.registrationDate.substr(0,10);
                                            			$('#txtRegistrationDateEdit').val(regDate);
                                            						$('#txtDescriptionEdit').val(vehicle.description);

			var acDate = vehicle.acquisitionDate.substr(0,10);
			$('#txtAcquisitionDateEdit').val(acDate);
						$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
									$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
												$('#ddlLocationEdit').val(vehicle.locationid);
															$('#txtPowerEdit').val(vehicle.power);
																		$('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#txtNetWeightEdit').val(vehicle.netWeight);
						$('#txtRemarksEdit').val(vehicle.remarks);
/*			$('#ddlEmployeeEdit').val(vehicle.employeeid);*/


			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);

		});
		$('#editModal').modal();
	});

/*	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();
	});*/
});