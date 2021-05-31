$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(contact, status){
			$('#idEdit').val(contact.id);
			$('#firstNameEdit').val(contact.firstname);
			$('#LastNameEdit').val(contact.lastname);
			$('#phoneEdit').val(contact.phone);
			$('#emailEdit').val(contact.email);
			$('#mobileEdit').val(contact.mobile);
			$('#remarksEdit').val(contact.remarks);

		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(contact, status){
			$('#idDetails').val(contact.id);
			$('#descriptionDetails').val(contact.description);
			$('#codeDetails').val(contact.code);
			$('#lastModifiedByDetails').val(contact.lastModifiedBy);
			$('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});