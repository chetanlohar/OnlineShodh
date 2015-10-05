function getState() {
	var countryId = $('#countryId').val();
	
	$.ajax({
		type : "POST",
		url : "/onlineshodh/towns/showStates",
		dataType : 'json',
		data : {
			"countryID" : countryId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#townStates').find('option').remove().end();
		     $('#townStates').append(
			 $("<option value='0'></option>").text("--Select--"));
			 

			jQuery.each(response, function(index, item) {
				$('#townStates').append(
						$("<option></option>").text(this.stateName).val(
								this.stateId));
			});

		},
		error : function(e) {
			
			console.log(e)
		}
	});

}

//get All Cities
function getCity() {
	var StateId = $('#townStates').val();
	
	$.ajax({
		type : "POST",
		url : "/onlineshodh/towns/showCities",
		dataType : 'json',
		data : {
			"stateID" : StateId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#stateCities').find('option').remove().end();
		     $('#stateCities').append(
			 $("<option value='0'></option>").text("--Select--"));
			 

			jQuery.each(response, function(index, item) {
				$('#stateCities').append(
						$("<option></option>").text(this.cityName).val(
								this.cityId));
			});

		},
		error : function(e) {
			
			console.log(e)
		}
	});

}



