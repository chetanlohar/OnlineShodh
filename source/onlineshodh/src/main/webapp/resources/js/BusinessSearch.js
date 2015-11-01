$(function() {
		$('#searchButton')
				.click(
						function() {
							$
									.ajax({
										type : "POST",
										url : "/onlineshodh/admin/clients/getClient",
										dataType : 'json',
										data : {
											"searchBy" : $('#searchBy').val(),
											"keyword" : $('#keyword').val()
										},
										success : function(response) {

											console.log(response)

											$('#dataTables-example')
													.find('.ab').remove(); 
											 jQuery
													.each(
															response,
															function(index,
																	item) {
																	var newRow = jQuery('<tr class="ab"><td>'
																			+ item.userDetailsId
																			+ '</td><td>'
																			+ item.regDate
																			+ '</td><td>'
																			+ item.name
																			+ '</td><td>'
																			+ item.email
																			+ '</td><td>'
																			+ item.phone1
																			+ '</td><td>'
																			+ item.phone2
																			+ '</td><td>'
																			+ item.userId
																			+ '</td><td><img src=${pageContext.request.contextPath}/admin/clients/load/logo/'+item.userDetailsId+'/>'

																			+ '</td><td>'
																			+ '<a href=${pageContext.request.contextPath}/admin/business/'+item.userDetailsId+'>'
																			+ 'Select'
																			+ '</a></td></tr>');
																	jQuery(
																			'#dataTables-example')
																			.append(
																					newRow);
																	
                                                               
															});

										},
										error : function(e) {
											console.log(e)
											alert("Please Enter Valid keywords")
											/* jQuery('#error')
											.append(e); */
										}
									})

						});
	});

