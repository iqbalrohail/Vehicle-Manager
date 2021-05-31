$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleMaintenance, status){
			$('#idEdit').val(vehicleMaintenance.id);

			//var startDate = vehicleMaintenance.startDate.substr(0,10);
			$('#startDateEdit').val(vehicleMaintenance.startDate);

			//var endDate = vehicleMaintenance.endDate.substr(0,10);
            			$('#endDateEdit').val(vehicleMaintenance.endDate);

            			$('#priceEdit').val(vehicleMaintenance.price);

			$('#ddlsupplieridEdit').val(vehicleMaintenance.supplierid);
			$('#remarksEdit').val(vehicleMaintenance.remarks);
		});
		$('#editModal').modal();
	});

});