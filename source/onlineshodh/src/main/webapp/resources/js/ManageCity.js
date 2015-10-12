function getState() {
	var countryId = $('#countryId').val();
	
	$.ajax({
		type : "POST",
		url : "/onlineshodh/admin/cities/showstates",
		dataType : 'json',
		data : {
			"countryID" : countryId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#countryStates').find('option').remove().end();
		     $('#countryStates').append(
			 $("<option value='0'></option>").text("--Select--"));
			 

			jQuery.each(response, function(index, item) {
				$('#countryStates').append(
						$("<option></option>").text(this.stateName).val(
								this.stateId));
			});

		},
		error : function(e) {
			
			console.log(e)
		}
	});

}
