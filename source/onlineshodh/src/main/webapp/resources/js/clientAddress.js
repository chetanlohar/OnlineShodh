//getAllTowns
function getTown() {
	
	var cityId = $('#cityId').val();
  $.ajax({
		type : "POST",
		url : "/onlineshodh/admin/clients/showTowns",
		dataType : 'json',
		data : {
			"cityId" : cityId
		},
		success : function(response) {
			/*alert(response)*/
			console.log(response)

			
			$('#town').find('option').remove().end();
		     $('#town').append(
			 $("<option value='0'></option>").text("--Select--"));
			 

			jQuery.each(response, function(index, item) {
				$('#town').append(
						$("<option></option>").text(this.townName).val(
								this.townId));
			});
			$('#town').append(
					 $("<option value=25></option>").text("--OtherTown--"));

		},
		error : function(e) {
			alert(" error "+e)
			console.log(e)
		}
	});

}


function getOtherTown() {
	
	
}
