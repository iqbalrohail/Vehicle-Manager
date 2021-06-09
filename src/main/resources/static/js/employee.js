$('document').ready(function() {

	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(employee, status){
			$('#txtIdEdit').val(employee.id);

			$('#firstnameEdit').val(employee.firstname);

			$('#lastnameEdit').val(employee.lastname);

			$('#jobtitleEdit').val(employee.jobtitleid);

			$('#othernameEdit').val(employee.othername);


		$('#titleEdit').val(employee.title);

		$('#addressEdit').val(employee.address);

		$('#stateEdit').val(employee.stateid);

		$('#countryEdit').val(employee.countryid);


		$('#cityEdit').val(employee.city);

		$('#phoneEdit').val(employee.phone);

		$('#mobileEdit').val(employee.mobile);

		$('#emailEdit').val(employee.email);

		$('#initialsEdit').val(employee.initials);

		$('#socialSecurityNumberEdit').val(employee.socialSecurityNumber);

		$('#genderEdit').val(employee.gender);

		$('#maritalStatusEdit').val(employee.maritalStatus);


			var hireDate = employee.hireDate.substr(0,10);
			$('#hireDateEdit').val(employee.hireDate);

			var dateOfBirth = employee.dateOfBirth.substr(0,10);
            			$('#dateOfBirthEdit').val(employee.dateOfBirth);

		});
		$('#editModal').modal();
	});

	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();
	});

});