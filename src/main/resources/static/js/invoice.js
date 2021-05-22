$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoice.invoiceDate);
			$('#ddlClientEdit').val(invoice.clientid);
			$('#remarksEdit').val(invoice.remarks);
		});
		$('#editModal').modal();
	});

});