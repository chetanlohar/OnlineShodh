function getState(path) {
	var countryId = $('#countryId').val();
	
	$.ajax({
		type : "POST",
		url : path+"/admin/towns/showStates",
		dataType : 'json',
		data : {
			"countryID" : countryId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#townStates').find('option').remove().end();
			$('#stateCities').find('option').remove().end();
			$('#towns').find('option').remove().end();
		     $('#townStates').append(
			 $("<option value='0'></option>").text("--Select--"));
		     $('#stateCities').append(
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
function getCity(path) {
	var StateId = $('#townStates').val();
	
	$.ajax({
		type : "POST",
		url : path+"/admin/towns/showCities",
		dataType : 'json',
		data : {
			"stateID" : StateId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#stateCities').find('option').remove().end();
			$('#towns').find('option').remove().end();
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

//get All Towns
function getTowns(path) {
	var cityId = $('#stateCities').val();
	
	$.ajax({
		type : "POST",
		url : path+"/admin/towns/showTowns",
		dataType : 'json',
		data : {
			"cityId" : cityId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#towns').find('option').remove().end();
		     $('#towns').append(
			 $("<option value='0'></option>").text("--Select--"));
			jQuery.each(response, function(index, item) {
				$('#towns').append(
						$("<option></option>").text(this.townName).val(
								this.townId));
			});

		},
		error : function(e) {
			
			console.log(e)
		}
	});

}



