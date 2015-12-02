function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition, showError);
		} else {
			
		}
}

function showPosition(position) {
	getAddress(position.coords.latitude,position.coords.longitude);
}

function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            console.log("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
        	console.log("Location information is unavailable.");
            break;
        case error.TIMEOUT:
        	console.log("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
        	console.log("An unknown error occurred.");
            break;
    }
}

function getAddress(lat,longitude)
{
		$.ajax({
			type : "GET",
			url : "http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+longitude+"&sensor=true",
			dataType : 'json',		
			success : function(response) {
				console.log(response);
				var district; // administrative_area_level_2
				
				if(response.results[0].address_components[5].types[0] == "administrative_area_level_2")
				{
					district = response.results[0].address_components[5].long_name;
				}
				else if(response.results[0].address_components[4].types[0] == "administrative_area_level_2")
				{
					district = response.results[0].address_components[4].long_name;
				}
				else if(response.results[0].address_components[3].types[0] == "administrative_area_level_2")
				{
					district = response.results[0].address_components[3].long_name;
				}
				else if(response.results[0].address_components[2].types[0] == "administrative_area_level_2")
				{
					district = response.results[0].address_components[2].long_name;
				}
				else if(response.results[0].address_components[1].types[0] == "administrative_area_level_2")
				{
					district = response.results[0].address_components[1].long_name;
				}
				
				var locality = "";
				if(response.results[0].address_components[4].types[0] == "locality")
				{
					locality = response.results[0].address_components[4].long_name;
				}
				else if(response.results[0].address_components[3].types[0] == "locality")
				{
					locality = response.results[0].address_components[3].long_name;
				}
				else if(response.results[0].address_components[2].types[0] == "locality")
				{
					locality = response.results[0].address_components[2].long_name;
				}
				else if(response.results[0].address_components[1].types[0] == "locality")
				{
					locality = response.results[0].address_components[1].long_name;
				}
				
				
				var sublocality = ""; // sublocality_level_1
				
				var targetCityTown = "";
				
				if(district == locality)
				{
					if(response.results[0].address_components[3].types[0]=="sublocality_level_1")
					{
						sublocality = response.results[0].address_components[3].long_name;
						if(sublocality!="")
							targetCityTown = district+" ("+sublocality+")";
					}
					else if(response.results[0].address_components[2].types[0]=="sublocality_level_1")
					{
						sublocality = response.results[0].address_components[2].long_name;
						if(sublocality!="")
							targetCityTown = district+" ("+sublocality+")";
					}
					else if(response.results[0].address_components[1].types[0]=="sublocality_level_1")
					{
						sublocality = response.results[0].address_components[1].long_name;
						if(sublocality!="")
							targetCityTown = district+" ("+sublocality+")";
					}
				}
				else
				{
					if(locality!="")
						targetCityTown = district+" ("+locality+")";
					else
						targetCityTown = district+" ("+district+")";
				}
				console.log("targetCityTown: "+targetCityTown.toUpperCase());
				$("#citysearch1").val(targetCityTown.toUpperCase());
				
			},
			error : function(e) {
				console.log(e)
			}
		});
}

/*function getAddressByIp()
{
	$.ajax({
		type : "GET",
		url : "http://freegeoip.net/json/113.193.31.110",
		dataType : 'json',
		success : function(response) {
			console.log(response);
		},
		error : function(e) {
			console.log(e)
		}
	});
}*/