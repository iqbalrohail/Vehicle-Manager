$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#codeEdit').val(state.code);
			$('#capitalEdit').val(state.capital);
			$('#nameEdit').val(state.name);
			$('#ddlCountryDetails').val(state.countryid);
			$('#detailsEdit').val(state.details);
		});
		$('#editModal').modal();
	});




	$('.table #countryModal').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(country, status){
			$('#CidEdit').val(country.id);
			$('#CcodeEdit').val(country.code);
			$('#CcapitalEdit').val(country.capital);
			$('#nationalityEdit').val(country.nationality);
			$('#continentEdit').val(country.continent);
			$('#descriptionEdit').val(country.description);
		});
		$('#Country').modal();
	});




	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
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