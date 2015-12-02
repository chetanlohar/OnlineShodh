function getBusinesses(path)
{
	var tagName = $("#searchid").val();
	var cityName = $("#citysearch").val();
	
	console.log(cityName+":"+tagName);
	
	window.location.href = path+'/search/businesses?tagName='+tagName+'&cityName='+cityName;
}