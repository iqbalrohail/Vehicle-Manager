$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(employeeType, status){
			$('#idEdit').val(employeeType.id);
			$('#detailsEdit').val(employeeType.details);
			$('#descriptionEdit').val(employeeType.description);
		});
		$('#editModal').modal();
	});


});