$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(jobTitle, status){
			$('#idEdit').val(jobTitle.id);
			$('#detailsEdit').val(jobTitle.details);
			$('#descriptionEdit').val(jobTitle.description);
		});
		$('#editModal').modal();
	});


});