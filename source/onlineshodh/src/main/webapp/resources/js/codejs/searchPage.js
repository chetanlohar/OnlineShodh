function saveEnquiry() {
	var businessId = $('#"successMsgEnquiry"').val();
	$.ajax({
		type : "POST",
		url : "/business/enquiry/save",
		contentType : "application/json",
		dataType : 'json',
		data : JSON.stringify({
			"companyName" : $('#org_name').val(),
			
		}),
		success : function(response) {
			console.log(response);
			
		},
		error : function(e) {
			
			console.log(e)
		}
	});

}