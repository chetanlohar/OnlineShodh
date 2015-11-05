$(document).ready(function() {

	/*
	  =========================
	   Search CLIENT VALIDATION
	  ===========================
	 */

	$('#clientsearch').validate({

		rules : {
			searchBy : {

				required : true
			},
			clientsearchbox : {
				required : true
			}

		},
		messages : {

			searchBy : "Please Select Valid Option",
			clientsearchbox : "Please Enter Valid Input"
		},

		highlight : function(element) {
			$(element).closest('.input-group').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.input-group').removeClass('has-error');
		},

		errorElement : 'span',
		errorClass : 'berror',
		errorPlacement : function(error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		},

	});
	
	
	/*
	  =========================
	   ADD CLIENT VALIDATION
	  ===========================
	 */
	
	
	$.validator.addMethod(
		    "maxfilesize",
		    function (value, element) {
		        return this.optional(element) || (element.files && element.files[0]
		                               && element.files[0].size < 1024  * 300);
		    },
		    'The file size can not exceed 300KB.'
		);
	
	$('#bclientupdate').validate({

		rules : {
			"businessName" : {

				required : true,
				minlength:2
			},
			file : {
				required : true,
			 	maxfilesize:true,
	        	 extension: "png|jpe?g|gif"
			},
			
			"businessDesc":{
				required : true
				
			},
			"personName":{
				required : true
			},
			"email":{
				required : true,
				email:true
				
			},
			"website":{
				required : true,
				url:true
			},
			
			"subCategory.category.categoryId":{
				required : true,
				min:1
			},
			"subCategory.subCategoryId":{
				required : true,
				min:1
			},
			"rank":{
				required : true,
				number:true,
				minlength:1,
				maxlength:2
				
			},
			"keywords":{
				required : true
			}

		},
		messages : {

			"businessName" : "Please Select Valid Business Name",
			file : "Please Enter Valid Logo Image",
			"businessDesc":"Please Enter Valid Business Description", 
			"personName":"Please Enter Valid Person Name",
			"email":"Please Enter Valid Email Id",
			"website":"Please Enter Valid Website Address",
			"subCategory.category.categoryId":"Please Enter Valid Category",
			"subCategory.subCategoryId":"Please Enter Valid Sub-Category",
			"rank":"Please Enter Valid Rank",
			"keywords":"Please Enter Some Keywords"
		},

		 highlight: function(element) {
	          $(element).closest('.space').addClass('has-error');
	      },
	      unhighlight: function(element) {
	          $(element).closest('.space').removeClass('has-error');
	      },
	      errorElement: 'span',
	      errorClass: 'error',
	      errorPlacement: function(error, element) {
	    	  
	    	  // if element is file type, we put the error message in its grand parent
	          if (element.prop("type") === "file") {
	              error.insertAfter(element.parent().parent());
	          } else {
	        	   error.insertAfter(element.parent());
	          }
	    	  },

	});
	

});