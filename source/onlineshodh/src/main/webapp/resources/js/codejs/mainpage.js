function getBusinesses()
{
	var tagName = $("#searchid").val();
	var cityName = $("#citysearch").val();
	
	console.log(cityName+":"+tagName);
	
	window.location.href = '/onlineshodh/search/businesses?tagName='+tagName+'&cityName='+cityName;
}