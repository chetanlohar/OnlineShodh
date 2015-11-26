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
	
	jQuery.validator.addMethod("CustEmail", function(value, element) {
	 	 
		  return this.optional( element ) || /^([a-zA-Z0-9_\-])+(\.([a-zA-Z0-9_\-])+)*@((\[(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5])))\.(((([0-1])?([0-9])?[0-9])|(2[0-4][0-9])|(2[0-5][0-5]))\]))|((([a-zA-Z0-9])+(([\-])+([a-zA-Z0-9])+)*\.)+([a-zA-Z])+(([\-])+([a-zA-Z0-9])+)*))$/.test( value );
		}, 'Please enter a valid email address.');

	$('#bclientupdate').validate({

		rules : {
			"businessName" : {

				required : true,
				minlength:2
			},
			file : {
				
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
				CustEmail:true
				
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

			"businessName" : "Please Enter Valid Business Name",
			file :{ 
				  maxfilesize:"The file size can not exceed 300KB."
			
			},
			"businessDesc":"Please Enter Valid Business Description", 
			"personName":"Please Enter Valid Person Name",
			"email":"Please Enter Valid Email Id",
			
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
	              
	              error.removeClass('error,errorimg').addClass('errorimg');
	          } else {
	        	   error.insertAfter(element.parent());
	        	   error.addClass('error');
	          }
	    	  },

	});
	
	
	
	/*
	  =========================
	   BUSINESS CLIENT ADDRESS VALIDATION
	  ===========================
	 */
	

	
	$('#bclientaddupdate').validate({

		rules : {
			"address" : {

				required : true
				
			},
			"street": {
				required : true
			 	
			},
			
			"landMark":{
				required : true
				
			},

			"city.state.country.countryId":{
				required : true,
				min:1
			},
			"city.state.stateId":{
				required : true,
				min:1
			},
			"city.cityId":{
				required : true,
				min:1
			},
			
			"town.townId":{
				required : true,
				min:1
			},
			otown:{
				required : true

				
			},
			pincode:{
				required : true,
				minlength:6,
				maxlength:6,
				number:true
			}

		},
		messages : {
 
			clietpin:"Please Enter Valid Pin Code",
			otown:"Please Enter Valid Town Name",
			"website":"Please Enter Valid Website Address",
			"city.state.country.countryId":"Please Enter Valid Country",
			"city.state.stateId":"Please Enter Valid State Name",
			"city.cityId":"Please Enter Valid City",
			"town.townId":"Please Enter Valid Town Name"
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
	          if(element.parent('.input-group').length) {
	              error.insertAfter(element.parent());
	          } else {
	              error.insertAfter(element);
	          }},

	});
	

	

});