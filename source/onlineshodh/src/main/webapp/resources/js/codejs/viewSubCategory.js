function getSubCategories() {
	var categoryId = $('#categoryname').val();
	$.ajax({
		type : "POST",
		url : "/onlineshodh/admin/subcategories/view/categories",
		dataType : 'json',
		data : {
			"categoryId" : categoryId
		},
		success : function(response) {
			console.log(response);
			$('#subcategoryname').find('option').remove().end();
		     $('#subcategoryname').append(
			 $("<option value='0'></option>").text("--Select--"));
			jQuery.each(response, function(index, item) {
				$('#subcategoryname').append(
						$("<option></option>").text(this.subCategoryName).val(
								this.subCategoryId));
			});
		},
		error : function(e) {
			
			console.log(e)
		}
	});

}
