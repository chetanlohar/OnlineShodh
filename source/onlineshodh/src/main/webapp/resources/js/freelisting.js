$(document).ready(
				function() {
				 
					$("#featureTable").on(
							'click', '.EditFeature',
							function(e) {
								
								var valfeature = $(this).parent().siblings(
										":nth-child(2)").text()
								var valfeatureid = $(this).parent().siblings(
										":nth-child(1)").text()
								var url2 = $("#featureurl1").val();
								$("#feature").val(valfeature);
								ftUrl=(url2 + valfeatureid)
								$(".flfeatures").html('Update');
								flag1 = true;
							});
				});


var flag = false;
var flag1 = false;
var phUrl;
var ftUrl;

function addPhone() {
	var phoneurl;
	if (flag == true) {

		phoneurl=phUrl;
		/* phoneurl = $("#phoneurl1").val(); */
	} else {
		phoneurl = $("#phoneurl").val();
	}
	
	$("#phonebutton").html('Add');
	$
			.ajax({
				type : "POST",
				url : phoneurl,
				datatype : "json",
				data : {
					"phonetype" : $('#phonetype').val(),
					"contact" : $('#contact').val(),
				},
				success : function(response) {
					 
					console.log(response)
					$('#phoneTable').find('tbody').remove();
					jQuery.each(response,function(index, item) {
						
						/* $('.phoneTable tbody').append('<tr class="child"><td>'+this.freeBuinessPhoneId+'</td><td>'+this.phone+'</td><td>'+this.phonetype+'</td><td><button class="upcontact btn-info btn-xs">Edit</button></td><td><a href="/onlineshodh/freelisting/'+item.freeListingBusinessEntity.freelistingbusinessdetailsId+'/'+item.freeBuinessPhoneId+'/deletePhone"><button class="btn btn-xs btn-danger">Delete<button></a></td><td>Verify</td></tr>'); */
						if(item.freeBuinessPhoneId!=null){
						var newRow = jQuery('<tr><td>'
												+ item.freeBuinessPhoneId
												+ '</td><td>'
												+ item.phone
												+ '</td><td>'
												+ item.phonetype
												+ '</td><td><button class="upcontact btn-info btn-xs">Edit</button></td><td><a href="/onlineshodh/freelisting/'+item.freeListingBusinessEntity.freelistingbusinessdetailsId+'/'+item.freeBuinessPhoneId+'/deletePhone"><button class="btn btn-xs btn-danger">Delete</button></a></td><td>Verify</td></tr>')

										jQuery('#phoneTable')
												.append(newRow); 
						}else{
							alert("exist")
						}
			});
					
						 
						flag=false;
						 $('#contact').val('');
						//location.reload(); 
					  

				},
				error : function(error) {
					console.log(error)
				}

			});

}

function addFeature() {

	var url;
	if (flag1 == true) {
		/* alert($('#featureurl1').val())    */
		url = ftUrl;
	} else {
		url = $('#featureurl').val();
	}
	$(".flfeatures").html('Add');
	$
			.ajax({
				type : "POST",
				url : url,
				datatype : "json",
				data : {
					"feature" : $('#feature').val()
				},
				success : function(response) {

					console.log(response)
					$('#featureTable').find('tbody').remove();

					jQuery
							.each(
									response,
									function(index, item) {

										var newRow = jQuery('<tr><td>'
												+ item.freelistingBusinessFeatureId
												+ '</td><td>'
												+ item.freelistingBusinessFeature
												+ '</td><td><button class="EditFeature btn-info btn-xs">Edit</button></td><td><a href="/onlineshodh/freelisting/'+item.business.freelistingbusinessdetailsId+'/'+item.freelistingBusinessFeatureId+'/deleteFeature"><button class="btn btn-xs btn-danger">Delete</button></a></td></tr>')
										jQuery('#featureTable').append(
												newRow);
									});
					
					$('#feature').val('');
				},
				error : function(error) {
					console.log(error)
				}

			});
}

$(document).ready(function() {

	$("#phoneTable").on('click','.upcontact', function() {
		
		flag = true;

		var valp = $(this).parent().siblings(":nth-child(2)").text()
		var valpid = $(this).parent().siblings(":nth-child(1)").text()
		$("#contact").val(valp);
		var url1 = $("#phoneurl1").val();
		phUrl=url1 + valpid;
		
		/* $("#phoneurl1").val(url1 + valpid); */

		$("#phonebutton").html('Update');

	});
});

$(document).ready(function() {
	/* 		$('#fl_contact').DataTable({
				  "paging":   false,
			        "ordering": false,
			        "info":     true
			});
			
			$('#fl_feature').DataTable({
				responsive : true
			});
	 */
});

