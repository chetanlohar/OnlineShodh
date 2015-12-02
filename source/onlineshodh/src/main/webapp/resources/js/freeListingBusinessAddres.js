function getTown(path) {
	
	var cityId = $('#cityId').val();
    
	
	$.ajax({
		type : "POST",
		url : path+"/freelisting/showTowns",
		dataType : 'json',
		data : {
			"cityId" : cityId
		},
		success : function(response) {
			
			console.log(response)

			
			$('#town').find('option').remove().end();
		     $('#town').append(
			 $("<option value='0'></option>").text("--Select--"));
			 

			jQuery.each(response, function(index, item) {
				$('#town').append(
						$("<option></option>").text(this.townName).val(
								this.townId));
			});
			/*$('#town').append(
					 $("<option value=25></option>").text("--OtherTown--"));*/

		},
		error : function(e) {
			
			console.log(e)
		}
	});

}
